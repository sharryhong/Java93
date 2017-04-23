"use strict"

module.exports = {
  //
  setConnection(con) {
    //이 함수가 소속된 객체에 connection 프로퍼티 추가하고 그 자체를 넘긴다.
    this.connection = con
  },

  selectList(pageNo, successFn, errorFn) {
    this.connection.query(
      'select m.mno, m.name, m.tel, m.email, s.work \
      from stud s inner join memb m on s.sno=m.mno  \
      order by m.name asc \
      limit ?, ?',
      [(pageNo - 1) * 3, 3],
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          // 쿼리 결과값을 results에 담아 보낸다.
          successFn(results)
        }
      }) // connection.query()
  },//selectList()

  countAll(successFn, errorFn) {
    // count(*) : row갯수. cnt는 별명. 이 값을 results에 담는다.
    this.connection.query(
      'select count(*) cnt from stud',
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          // 성공하면 row갯수를 매개변수인 successFn함수의 아규먼트로 보낸다.
          successFn(results)
        }
      }) //connection.query()
  },//countAll()

  selectOne(no, successFn, errorFn) {
    this.connection.query(
      'select m.mno, m.name, m.tel, m.email, s.work, s.schl_nm \
      from stud s inner join memb m on s.sno=m.mno \
      where s.sno=?',
      [no],
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results[0])
        }
      }) // connection.query()
  },//selectOne()

  insert(student, successFn, errorFn) {
    this.connection.query(
      'insert into stud(sno,work,schl_nm) values(?,?,?)',
      [ student.no, student.working, student.schoolName],
      function(error, result) {
        if (error) {
          errorFn(error)
        } else {
          successFn(result)
        }
      }) //connection.query()
  }, //insert()

  update(student, successFn, errorFn) {
    this.connection.query(
      'update stud set work=?, schl_nm=? where sno=?',
      [student.working, student.schoolName, student.no],
      function(error, result) {
        if (error) {
          errorFn(error)
        } else {
          successFn(result)
        }
      }) //connection.query()
  }, //update()

  delete(no, successFn, errorFn) {
    this.connection.query(
      'delete from stud where sno=?',
      [no],
      function(error, result) {
        if (error) {
          errorFn(error)
        } else {
          successFn(result)
        }
      })
  }//delete()

}//module.exports
