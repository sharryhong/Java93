/*  외부키 컬럼 FK(Foreign Key)만들기
*/

/* 1) 부모 테이블 선언 */
create table t2 (
  no int,
  title varchar(10),
  content text
);

alter table t2
  add constraint primary key (no);

alter table t2
  modify column no int auto_increment;

-- 예제 데이터 입력
insert into t2(title, content) values('제목1', '내용...');
insert into t2(title, content) values('제목2', '내용...');
insert into t2(title, content) values('제목3', '내용...');

/* 2) 자식 테이블 생성

*/
create table t3 (
  no int,
  bno int not null,
  file varchar(100) not null
);

alter table t3
  add constraint primary key (no);

alter table t3
  modify column no int auto_increment;

-- 예제 데이터 입력
--
insert into t3(bno, file) values(10, 'aaa.gif');

--
delete table t3;

/**/
alter table t3
  add foreign key (bno) references t2(no);
-- 실패하더라도 no는 카운트 된다는 점을 명심
insert into t3(bno, file) values(2, 'aaa.gif');

-- 이제 t2를 지울 수 없다!
drop table t2;

-- 자식테이블인 t3를 먼저 지우고 t3를 지울 수 있다.

--
