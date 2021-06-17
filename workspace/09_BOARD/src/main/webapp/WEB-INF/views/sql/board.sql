create table board
(
    no number primary key,
    writer varchar2(32),
    title varchar2(1000) not null,
    content varchar2(4000),
    postdate date
);

create sequence board_seq increment by 1 start with 1 nocycle nocache;

