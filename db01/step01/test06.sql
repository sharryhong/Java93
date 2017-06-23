/* 서브 쿼리
*/

-- test05.sql의 마지막예제를 서브쿼리로 바꿔보자.
-- 6_ 수강신청번호, 강의제목, 교실이름, 매니저이름, 매니저직급, 수강생명, 재직여부
select la.lano,
       l.titl,
       cr.name,
       m.name,
       mr.posi,
       m2.name,
       s.work
from lect_appy la
  inner join lect l on la.lno = l.lno
  left outer join croom cr on l.crmno = cr.crmno
  left outer join memb m on l.mrno = m.mno
  left outer join mgr mr on l.mrno = mr.mrno
  left outer join memb m2 on la.sno = m2.mno
  left outer join stud s on la.sno = s.sno;

/* 1) select 절(clause)에 서브쿼리 사용하기
데이터를 select할 때마다 실행하므로 성능을 떨어트린다. => 가능하면 join으로 써야한다.
*/
-- la, l은 사용해야하므로 최대한 서브쿼리 사용한 예(극단적)
select la.lano,
       l.titl,
       (select name from croom where crmno = l.crmno) room,
       (select name from memb where mno = l.mrno) mname,
       (select posi from mgr where mrno = l.mrno) position,
       (select name from memb where mno = la.sno) sname,
       (select work from stud where sno = la.sno) working
from lect_appy la
  inner join lect l on la.lno = l.lno;

/* 2) from 절에 서브쿼리 사용하기 */
--
select mr.mrno, m.name
from mgr mr inner join memb m on mr.mrno = m.mno;

--
select lno, titl, mrno
from lect;

-- 강의번호와 강의명, 매니저이름 데이터 뽑기
-- 방법 1_ 일반 조인으로 해결하기
select l.lno, l.titl, m.name
from lect l
  left outer join memb m on l.mrno = m.mno;

-- 방법 2_ 서브 쿼리를 사용하여 조인하기
-- memb테이블 이름 자리에 매니저이름 뽑는 쿼리를 넣는다.
select l.lno, l.titl, t1.name
from lect l
  left outer join (
    select mr.mrno, m.name
    from mgr mr inner join memb m on mr.mrno = m.mno) t1
    on l.mrno = t1.mrno;
-- 매니저 1이 담당하는 강의만 뽑고 싶다면
select l.lno, l.titl, t1.name
from lect l
  inner join (
    select mr.mrno, m.name
    from mgr mr inner join memb m on mr.mrno = m.mno
    where m.name = '매니저1') t1
    on l.mrno = t1.mrno;

/*  3) where 절에 서브쿼리 사용하기
 강남 강의실이 배정된 강의번호와 강의명, 강의실명을 출력하라.
 출력데이터 : 강의번호, 강의명 */

-- 일단 강의 정보 추출
select lno, titl, crmno
from lect;
-- 강남 강의실 정보 추출
select crmno, name
from croom
where name like '강남%';
-- 위 두개 결합하기
-- where절에 서브쿼리를 넣어 강남강의실이 배정된 강의정보 추출
select lno, titl, crmno
from lect l
where l.crmno in (select crmno from croom where name like '강남%');








--
