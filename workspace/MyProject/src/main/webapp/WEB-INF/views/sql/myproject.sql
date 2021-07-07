drop table member;
drop table member_log;
drop table imgboard;
drop table imgboard_reply;
drop table board;

-- 회원 테이블
create table member
(
	no number, -- 회원 번호 pk
	id varchar(50) not null unique, -- 아이디
	pw varchar2(32) not null, -- 비번
	name varchar2(50), -- 이름
	phone varchar2(50), -- 전화번호
	email varchar2(200) not null unique, -- 이메일
	address varchar2(200), -- 주소
	regdate date, -- 가입일
	state number -- 상태(정상: 0, 삭제: -1)
);
-- 회원 접속 기록(로그인, 로그아웃)
create table member_log
(
	no number, -- 회원 번호 pk
	id varchar(50), -- 아이디(member_id) fk
	login date,
	logout date
);


-- 이미지 게시판 테이블
create table imgboard
(
	idx number, -- 게시글 번호 pk
	writer varchar2(50), -- 작성자(member_id) fk
	title varchar2(2000) not null, -- 제목
	content varchar2(4000), -- 내용
	origin_filename varchar2(300), -- 원래 파일명
	save_filename varchar2(300), -- 저장된 파일명
	ip varchar2(20), -- 작성자 ip
	hit number, -- 조회수
	postdate date, -- 작성일
	lastmodified date -- 최종 수정일
);
-- 이미지 댓글 테이블
create table imgboard_reply
(
	idx number, -- 댓글 번호 pk
	writer varchar2(50), -- 작성자
	content varchar2(4000), -- 내용
	ip varchar2(20), -- 작성자 ip
	imgboard_idx number, -- 원글의 번호(imgboard_idx) fk
	postdate date -- 작성일
);


-- 자유 게시판(계층형)
create table board
(
	idx number, -- 게시글 번호 pk
	writer varchar2(50), -- 작성자
	title varchar2(1000) not null, -- 제목
	content varchar2(4000), -- 내용
	ip varchar2(20), -- 작성자 ip
	hit number, -- 조회수
	postdate date, -- 작성일
	lastmodified date, -- 최종수정일
	state number, -- 정상여부(정상: 0, 삭제: -1)
	groupno number, -- 게시글의 그룹 여부(어떤 게시글과 거기에 달린 댓글들은 모두 같은 그룹)
	groupord number, -- 그룹 내 표시 순서
	depth number -- 게시글/댓글 여부(게시글: 0, 댓글: 1 이상)
);


-- 시퀀스
drop sequence member_seq;
drop sequence member_log_seq;
drop sequence imgboard_seq;
drop sequence imgboard_reply_seq;
drop sequence board_seq;
create sequence member_seq increment by 1 start with 1 nocycle nocache;
create sequence member_log_seq increment by 1 start with 1 nocycle nocache;
create sequence imgboard_seq increment by 1 start with 1 nocycle nocache;
create sequence imgboard_reply_seq increment by 1 start with 1 nocycle nocache;
create sequence board_seq increment by 1 start with 1 nocycle nocache;


-- 기본키
alter table member add constraint member_pk primary key(no);
alter table member_log add constraint member_log_pk primary key(no);
alter table imgboard add constraint imgboard_pk primary key(idx);
alter table imgboard_reply add constraint imgboard_reply_pk primary key(idx);
alter table board add constraint board_pk primary key(idx);


-- 외래키
alter table member_log add constraint member_log_fk foreign key(id) references member(id);
alter table imgboard add constraint imgboard_member_fk foreign key(writer) references member(id); 
alter table imgboard_reply add constraint imgboard_reply_imgboard_fk foreign key(imgboard_idx) references imgboard(idx);

alter table imgboard drop constraint imgboard_member_fk;


