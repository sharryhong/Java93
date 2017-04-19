/* 테이블 생성 및 삭제
=> 문법
create table 테이블명(
  컬럼명 타입 옵션,
  ...
)
drop table 테이블명;
*/

-- 생성
create table t1 (
  no int,
  name varchar(255)
);
-- >show tables로 확인

-- 삭제
drop table t1;
