/*  where
--
*/

-- 실행 순서 : from -> where -> select -> order by
select lno, titl, mrno
from lect
where mrno is null
order by titl asc;

/*비교 연산자 : =, <, >, <=, >=, !=, <> */
select lno, titl, mrno
from lect
where mrno = 32;  -- 32번 매니저가 담당하고 있는 과목

select lno, titl, mrno
from lect
where mrno != 32;  -- null은 안나오네

select lno, titl, mrno
from lect
where mrno <> 32;  -- !=과 동일

select lno, titl, mrno, pric
from lect
where pric > 300000;

select lno, titl, mrno, pric
from lect
where pric < 300000;

-- 5월부터 시작하는 강의
-- 강의명, 시작일, 종료일
select titl, sdt, edt
from lect
where sdt >= '2017-5-1';

select lno, titl, mrno
from lect
where mrno = null;  -- null을 비교할 때는 =를 사용할 수 없다. 대신 is를 사용하라.

select lno, titl, mrno
from lect
where mrno is null;

select lno, titl, mrno
from lect
where mrno is not null;


/* 산술 연산자 : +, -, *, /
*/
-- 학원비를 20%할인한 것을 별명 pric2
-- JS, Java등에서 할 수도 있지만 이렇게 DB에서 할 수 있다.
select lno, titl, pric, (pric - (pric * 0.2)) pric2
from lect;

-- 시작일을 27일 미루기 => Oracle은 되는데 mysql은 안됨
select titl, sdt, sdt + 27
from lect;
-- 결과 날짜포멧이 20170129 이렇게 나온다. 날짜가 이상하게 나온다.

-- 날짜 더하기
-- 제공함수 사용. 이렇게 해야 제대로 된 날짜가 나온다. 날짜 포맷도 2017-01-29
select titl, sdt, date_add(sdt, interval 27 day)
from lect;


/* 논리 연산자 : and, or, not */
select lno, titl, mrno, pric
from lect
where pric > 300000 and pric < 500000;

select lno, titl, mrno, pric
from lect
where pric < 300000 or pric > 1000000;

select lno, titl, mrno
from lect
where not(mrno = 32);  -- 이것도 null은 안나옴. 괄호 생략 가능

/* in 연산자 : in (값, 값, 값, ...)
--
*/
select lno, titl, mrno
from lect
where mrno in (31, 32);  -- 31, 32강사가 담당하는 강좌

/* like 연산자 : 문자열 비교 연산자
-- 검색할 때
*/
select lno, titl
from lect
where titl like '자바기초';

select lno, titl
from lect
where titl like '웹%';

select lno, titl
from lect
where titl like '%과정';

select *
from croom
where name like '강남_01';   --  언더바(_)는 문자 1개

/* between A and B 연산자
--
*/
select lno, titl, pric
from lect
where pric between 150000 and 450000;

select lno, titl, sdt, edt
from lect
where sdt between '2017-5-1' and '2017-6-30';

/* is null 연산자 : 값이 설정되지 않은 것 */
select lno, titl, crmno
from lect
where crmno is null;   -- 아직 강의실이 배정안된 강의

/* union 두 개의 결과를 더하는 연산자 */
select mrno from mgr;  -- 매니저 번호
select tno from tcher;  -- 강사 번호
select sno from stud;  -- 학생 번호

-- 한번에 여러 테이블을 불러와서 합친다.
select mrno, posi from mgr
union
select tno, hmpg from tcher
union
select sno, schl_nm from stud;

-- 중복이 자동으로 제거된다.
--
select mrno from mgr
union
select tno from tcher;

/* union all : 중복 값을 허용한다. */
select mrno from mgr
union all
select tno from tcher;
