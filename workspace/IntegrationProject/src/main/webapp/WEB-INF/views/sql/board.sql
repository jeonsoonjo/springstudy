drop table board;
create table board
(
	no number primary key,
	writer varchar2(32),
	title varchar2(32),
	content varchar2(32),
	postdate date
);

insert into board values(1, '관리자', '공지사항', '공지입니다.', sysdate);
insert into board values(2, '전지연', '요청사항', '요청입니다.', sysdate);
insert into board values(3, '전순조', '협조사항', '협조입니다.', sysdate);
insert into board values(4, '윤건우', '필독사항', '필독입니다.', sysdate);
insert into board values(5, '성봉구', '요구사항', '요구입니다.', sysdate);
commit

