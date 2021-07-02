drop table staff;
create table staff
(
	no number primary key,
	name varchar2(32),
	depart varchar2(32),
	salary number,
	regdate date
);

insert into staff values(1, '사원1', '관리부', '3000', sysdate);
insert into staff values(2, '사원2', '기획부', '2500', sysdate);
insert into staff values(3, '사원3', '회계부', '5000', sysdate);
insert into staff values(4, '사원4', '전산부', '4500', sysdate);
insert into staff values(5, '사원5', '기술부', '3500', sysdate);
insert into staff values(6, '사원6', '인사부', '3000', sysdate);
commit

