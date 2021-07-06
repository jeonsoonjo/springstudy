DROP TABLE MEMBER;
CREATE TABLE MEMBER (
	NO NUMBER PRIMARY KEY,
	ID VARCHAR2(20) NOT NULL UNIQUE,
	PW VARCHAR2(20) NOT NULL,
	NAME VARCHAR2(20),
	EMAIL VARCHAR2(20),
	REGDATE DATE
);

DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE;

INSERT INTO MEMBER VALUES (10000, 'admin', '1111', '관리자', 'admin@web.com', SYSDATE);
COMMIT