"use strict"

module.exports = {
  //
  setConnection(con) {
    //이 함수가 소속된 객체에 connection 프로퍼티 추가하고 그 자체를 넘긴다.
    this.connection = con
  },

  selectList(pageNo, successFn, errorFn) {
    this.connection.query(
      'select lno, titl, dscp, sdt, edt, qty, pric, thrs \
      from lect l \
      limit ?, ?',
      [(pageNo - 1) * 3, 3],
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results)
        }
      }) // connection.query()
  },//selectList()

  countAll(successFn, errorFn) {
    this.connection.query(
      'select count(*) cnt from lect',
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          console.log(results)
          successFn(results)
        }
      }) //connection.query()
  },//countAll()

  selectOne(no, successFn, errorFn) {
    this.connection.query(
      'select lno, titl, dscp, sdt, edt, qty, pric, thrs  \
      from lect l \
      where l.lno=?',
      [no],
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results[0])
        }
      }) // connection.query()
  },//selectOne()

  insert(lecture, successFn, errorFn) {
    this.connection.query(
      'insert into lect(lno, titl, dscp, sdt, edt, qty, pric, thrs) values(?,?,?,?,?,?,?,?)',
      [ lecture.no, lecture.titl, lecture.dscp, lecture.sdt, lecture.edt, lecture.qty, lecture.pric, lecture.thrs],
      function(error, result) {
        if (error) {
          errorFn(error)
        } else {
          successFn(result)
        }
      }) //connection.query()
  }, //insert()

  update(lecture, successFn, errorFn) {
    this.connection.query(
      'update lect set titl=?, dscp=?, sdt=?, edt=?, qty=?, pric=?, thrs=? where lno=?',
      [lecture.titl, lecture.dscp, lecture.sdt, lecture.edt, lecture.qty, lecture.pric, lecture.thrs, lecture.no],
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
      'delete from lect where lno=?',
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
