desc emaillist;

-- select _C
select * from emaillist;
-- 최신 순
select no, first_name, last_name, email from emaillist order by no desc;

-- insert _R
insert into emaillist values(null, '박', '영서', 'pys6790@naver.com');

-- update _U

-- delete _D