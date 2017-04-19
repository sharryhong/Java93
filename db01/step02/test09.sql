/*  auto_increment
*/

/* 1) 테이블 정의할 때 붙이기 */
create table t2 (
  no int primary key auto_increment,
  name varchar(10),
  email varchar(50)
);

/* 2) 테이블 정의한 후 붙이기 */
create table t2 (
  no int,
  name varchar(10),
  email varchar(50)
);

alter table t2
  add constraint primary key (no);

-- 추가
-- datatype을 빠트릴수없다.
alter table t2
  modify column no int auto_increment;

-- 예제
insert into t2(name, email) values('홍길동', 'hong@test.com');
insert into t2(name, email) values('홍길동2', 'hong2@test.com');
insert into t2(name, email) values('홍길동3', 'hong3@test.com');

/* 번호에 구멍 내기 */
delete from t2 where no=2;
-- 추가 하면? 
insert into t2(name, email) values('홍길동4', 'hong4@test.com');





--
