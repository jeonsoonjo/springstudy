DROP TABLE MEMBER;
DROP SEQUENCE MEMBER_SEQ;

CREATE TABLE MEMBER
(
	NO NUMBER PRIMARY KEY,
	ID VARCHAR2(32) NOT NULL UNIQUE,
	PW VARCHAR2(64) NOT NULL, -- 암호화된 비밀번호 64바이트
	NAME VARCHAR2(32),
	EMAIL VARCHAR2(100) NOT NULL,
	REGDATE DATE
);

CREATE SEQUENCE MEMBER_SEQ INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;
insert into MEMBER values(member_seq.nextval, 'admin', '1111', '관리자', 'jeonsoonjo@gmail.com', sysdate);
insert into MEMBER values(member_seq.nextval, 'soonjo', '1111', '전순조', 'tinasoonj@naver.com', sysdate);
select * from member;

