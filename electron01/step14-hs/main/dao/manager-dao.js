"use strict"

module.exports = {
  //
  setConnection(con) {
    //이 함수가 소속된 객체에 connection 프로퍼티 추가하고 그 자체를 넘긴다.
    this.connection = con
  },

  selectList(pageNo, successFn, errorFn) {
    this.connection.query(
      'select m.mno, m.name, mr.posi, m.tel \
      from mgr mr inner join memb m on mr.mrno=m.mno  \
      order by m.name asc \
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
      'select count(*) cnt from mgr',
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results)
        }
      }) //connection.query()
  },//countAll()

  nameList(successFn, errorFn) {
    this.connection.query(
      'select m.name, mr.mrno \
      from memb m join mgr mr on m.mno=mrno',
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results)
        }
      }) // connection.query()
  }, // nameList()

  selectOne(no, successFn, errorFn) {
    this.connection.query(
      'select m.mno, m.name, m.email, m.tel, m.pwd, mr.posi, mr.fax, mr.path  \
      from mgr mr inner join memb m on mr.mrno=m.mno \
      where mr.mrno=?',
      [no],
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results[0])
        }
      }) // connection.query()
  },//selectOne()

  insert(manager, successFn, errorFn) {
    this.connection.query(
      'insert into mgr(mrno, posi, fax, path) values(?,?,?,?)',
      [ manager.no, manager.posi, manager.fax, manager.path],
      function(error, result) {
        if (error) {
          errorFn(error)
        } else {
          successFn(result)
        }
      }) //connection.query()
  }, //insert()

  update(manager, successFn, errorFn) {
    this.connection.query(
      'update mgr set posi=?, fax=?, path=? where mrno=?',
      [manager.posi, manager.fax, manager.path, manager.no],
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
      'delete from mgr where mrno=?',
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
