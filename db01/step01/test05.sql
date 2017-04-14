/* 조인
--
*/

select mno, name, tel, email from memb;
select sno, work, lst_schl, schl_nm from stud;

/* 1) CROSS 조인 = CARTESION 조인 : 안쓴다.
-- 방법 1.
*/
select mno, name, sno, work, lst_schl
from memb, stud; -- 두개의 테이블 조인

-- 방법 2. 대부분 현업에선 이렇게 별명을 붙여서 쓴다.
--
select m.mno, m.name, s.sno, s.work, s.lst_schl
from memb m, stud s;

-- 방법 3. 표준 문법
select m.mno, m.name, s.sno, s.work, s.lst_schl
from memb m cross join stud s;

-- 강의데이터와 교실데이터 조인
-- 오류. crmno가 두 테이블에 동일하게 존재하므로
select lno, crmno, titl, name
from lect cross join croom;
-- crmno만 동일하므로, 정확하게 지정해준다.
select lno, l.crmno, titl, name
from lect l cross join croom c;
-- 유지보수 : 실무에서는 명확하게 알리기 위해 무조건 테이블 별명을 붙인다. 한 줄 보다는 엔터친다.
select
  l.lno,
  l.crmno,
  l.titl,
  c.name
from lect l cross join croom c;

/* 2) NATURAL 조인
-- 우리가 생각하는 제대로 된 조인 방법
*/
-- 방법 1.
select
  l.lno, l.crmno, l.titl, c.crmno, c.name
from lect l, croom c
where l.crmno = c.crmno;
-- 방법 2.
select
  l.lno, l.crmno, l.titl, c.crmno, c.name
from lect l natural join croom c;

-- 주의! 두 테이블을 natural join하기 위해서는 같은 이름의 컬럼이 있어야한다.
-- 지금은 cross join과 같다.
select m.mno, m.name, s.sno, s.work, s.lst_schl
from memb m natural join stud s;
-- 이런 경우는 어떤 컬럼으로 조인할지 정확하게 지정해야한다.
select m.mno, m.name, s.sno, s.work, s.lst_schl
from memb m natural join stud s
where m.mno = s.sno;

/* 3) JOIN ~ ON
-- 바로 위의 where절 대신 사용 가능
*/
select m.mno, m.name, s.sno, s.work, s.lst_schl
from memb m join stud s on m.mno = s.sno;
-- 이렇게 일치하는 데이터끼리 묶는 것을 inner 조인이라 부른다.
-- default
select m.mno, m.name, s.sno, s.work, s.lst_schl
from memb m inner join stud s on m.mno = s.sno;

-- join ~ using ~ : 잘 안쓴다. join ~ on 을 많이 쓴다.

/* 4) outer 조인
-- inner조인의 문제점을 해결
*/
-- inner조인의 문제점
select l.lno, l.titl, c.name
from lect l inner join croom c on l.crmno = c.crmno;
-- 해결. 강의 테이블 기준
select l.lno, l.titl, c.name
from lect l left outer join croom c on l.crmno = c.crmno;
-- 강의실 테이블 기준
select l.lno, l.titl, c.name
from lect l right outer join croom c on l.crmno = c.crmno;


-- 상황에 맞춰서 쓰면된다.

/* 예) 수강 신청(기준) 정보를 다음과 같이 출력하라.
관련 테이블 :
  lect(강의정보), croom(강의실), mgr(매니저), lect_appy(수강신청), stud(학생), memb(회원기본정보)
출력결과 :
  수강신청번호, 강의번호(lect), 강의제목(lect), 교실이름(croom), 매니저이름(mgr), 매니저직급() 수강생명, 재직여부
*/
-- 1_ 수강신청번호, 강의제목을 출력해보자.
select la.lano, l.titl
from lect_appy la join lect l on la.lno = l.lno;
-- 2_ 수강신청번호, 강의제목, 교실이름 출력
select la.lano, l.titl, cr.name
from lect_appy la
  join lect l on la.lno = l.lno
  left outer join croom cr on l.crmno = cr.crmno;  -- 교실배정안된 것이 있기 때문에 outer join으로 해야한다.
-- 3_ 수강신청번호, 강의제목, 교실이름, 매니저이름 출력
select la.lano, l.titl, cr.name, m.name
from lect_appy la
  inner join lect l on la.lno = l.lno
  left outer join croom cr on l.crmno = cr.crmno
  left outer join memb m on l.mrno = m.mno;
-- 4_ 수강신청번호, 강의제목, 교실이름, 매니저이름, 매니저직급
select la.lano, l.titl, cr.name, m.name, mr.posi
from lect_appy la
  inner join lect l on la.lno = l.lno
  left outer join croom cr on l.crmno = cr.crmno
  left outer join memb m on l.mrno = m.mno
  left outer join mgr mr on l.mrno = mr.mrno;
-- 5_ 수강신청번호, 강의제목, 교실이름, 매니저이름, 매니저직급, 수강생명
select la.lano, l.titl, cr.name, m.name, mr.posi, m2.name
from lect_appy la
  inner join lect l on la.lno = l.lno
  left outer join croom cr on l.crmno = cr.crmno
  left outer join memb m on l.mrno = m.mno
  left outer join mgr mr on l.mrno = mr.mrno
  left outer join memb m2 on la.sno = m2.mno;
-- 6_ 수강신청번호, 강의제목, 교실이름, 매니저이름, 매니저직급, 수강생명, 재직여부
select la.lano, l.titl, cr.name, m.name, mr.posi, m2.name, s.work
from lect_appy la
  inner join lect l on la.lno = l.lno
  left outer join croom cr on l.crmno = cr.crmno
  left outer join memb m on l.mrno = m.mno
  left outer join mgr mr on l.mrno = mr.mrno
  left outer join memb m2 on la.sno = m2.mno
  left outer join stud s on la.sno = s.sno;
-- memb m(매니저이름 가져오기 위함), memb m2(수강생명 가져오기 위함) 별명 다르게 해야한다. 



--
