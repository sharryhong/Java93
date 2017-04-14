/*  order by
결과를 정렬할 때 사용
문법 :
select ~
from ~
where ~
order by 컬럼명 정렬순서

정렬순서
asc : 오름차순
desc : 내림차순
*/

-- 정렬순서 지정하지 않으면 기본이 asc
-- 이름기준 오름차순으로 정렬
select mno, name, tel, email
from memb
order by name asc;

-- 이름기준 내림차순으로 정렬
select mno, name, tel, email
from memb
order by name desc;

/* 여러개의 컬럼 정렬
*/
select lano, lno, sno
from lect_appy
order by lno desc, sno asc;

select lano, lno, sno
from lect_appy
order by lno asc, sno desc;

/* 실행 순서 : from -> select -> order by
--
*/
select lano, sno
from lect_appy
order by lno asc, sno desc;
