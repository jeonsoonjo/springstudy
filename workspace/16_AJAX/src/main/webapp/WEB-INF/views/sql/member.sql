DROP TABLE MEMBER;
DROP SEQUENCE MEMBER_SEQ;

CREATE TABLE MEMBER
(
	NO NUMBER PRIMARY KEY,
	ID VARCHAR2(32) NOT NULL UNIQUE,
	NAME VARCHAR2(64),
	ADDRESS VARCHAR2(100),
	GENDER VARCHAR2(10)
);

CREATE SEQUENCE MEMBER_SEQ INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;

insert into member values(member_seq.nextval, 'user1', '사용자1', '서울', '남');
insert into member values(member_seq.nextval, 'user2', '사용자2', '경기', '여');
insert into member values(member_seq.nextval, 'user3', '사용자3', '부산', '남');
insert into member values(member_seq.nextval, 'user4', '사용자4', '충청', '여');
insert into member values(member_seq.nextval, 'user5', '사용자5', '서울', '남');
insert into member values(member_seq.nextval, 'user6', '사용자6', '경기', '여');
insert into member values(member_seq.nextval, 'user7', '사용자7', '제주', '남');
insert into member values(member_seq.nextval, 'user8', '사용자8', '부산', '여');
insert into member values(member_seq.nextval, 'user9', '사용자9', '울산', '남');
insert into member values(member_seq.nextval, 'user10', '사용자10', '제주', '여');
insert into member values(member_seq.nextval, 'user11', '사용자11', '강원', '남');
insert into member values(member_seq.nextval, 'user12', '사용자12', '전주', '여');
insert into member values(member_seq.nextval, 'user13', '사용자13', '대구', '여');
insert into member values(member_seq.nextval, 'user14', '사용자14', '경기', '남');
insert into member values(member_seq.nextval, 'user15', '사용자15', '대전', '여');


