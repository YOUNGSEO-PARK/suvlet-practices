SELECT * FROM webdb.emaillist;
desc webdb.emaillist;

-- select _C
select * from webdb.emaillist;
-- 최신 순
select no, first_name, last_name, email from webdb.emaillist order by no desc;

-- insert _R
insert into emaillist values(null, '박', '영서', 'irene0seo97@gmail.com');

-- update _U

-- delete _D
