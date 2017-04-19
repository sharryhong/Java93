/* default
*/

create table t2 (
  no int,
  name varchar(10) default '홍길동',
  gender char(1) not null default 'W',
  height numeric(4, 1),
  intro text,
  birthday date,
  regdate datetime
);

alter table t2
add constraint primary key (no);

/* 예제 데이터 입력 : 최소 데이터 입력 */
insert into t2(no, gender)
values(1, 'M');
-- default 값이 있기 때문에 에러아님
insert into t2(no)
values(2);




















--
