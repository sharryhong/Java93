/*  alias (별명)
--
*/

-- 별명 부여하지 않으면 컬럼명대로
select lno, crmno, mrno, titl
from lect;

-- 컬럼에 별명 부여. as는 생략가능
-- 공백이 있을 경우 '' or "" 로 감싸야한다.
select lno, crmno as classRommNo, mrno managerNo, titl as 'class name'
from lect;

/* 그럼 주로 언제쓰나??
count(*) : lect 테이블의 row개수를 알려준다. 이걸 cnt라고 별명을 주어 사용한다.
*/
select count(*) as cnt from lect;
-- concat은 mysql에서 제공하는 함수
select concat('(', lno, ':', titl, '-', mrno, ')') lectureInfo from lect;
