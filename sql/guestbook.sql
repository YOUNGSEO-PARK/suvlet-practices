desc guestbook;
-- insert
insert into guestbook value(null, '박영서', '1234', '성공했다!!!', now());

-- select
select no, name, message, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from guestbook order by reg_date; 

