desc webdb.guestbook;


-- insert
insert into webdb.guestbook value(null, '박', '1234', '안녕~!', now());

-- select
select no, name, message, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from webdb.guestbook;

