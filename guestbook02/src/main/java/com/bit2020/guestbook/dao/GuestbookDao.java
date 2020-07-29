package com.bit2020.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2020.guestbook.vo.GuestbookVo;

public class GuestbookDao {

	public boolean insert(GuestbookVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC Driver(MariaDB Driver)
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL 준비
			String sql = "insert into webdb.guestbook value(null, ?, ?, ?, now())"; 
			pstmt = connection.prepareStatement(sql);

			// 4. 바인딩(binding)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());
			
			// 5. sql 실행
			int count = pstmt.executeUpdate(sql);
			result = (count == 1);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<GuestbookVo> findAll() {
		List<GuestbookVo> result = new ArrayList<>();
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC Driver(MariaDB Driver)
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statement 객체 생성
			stmt = connection.createStatement();

			// 4. SQL 실행
			// prepared statement
			String sql = "select no, name, message, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from webdb.guestbook order by reg_date";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String message = rs.getString(4);

				GuestbookVo vo = new GuestbookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPassword(password);
				vo.setMessage(message);

				result.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
