"use strict"

module.exports = {
  setConnection(con) {
    //이 함수가 소속된 객체에 connection 프로퍼티 추가하고 그 자체를 넘긴다.
    this.connection = con
  },

  insert: function(member, successFn, errorFn) {
    this.connection.query(
      'insert into memb(name,tel,email,pwd) values(?,?,?,password(?))',
      [ member.name, member.tel, member.email, member.password],
      function(error, result) {
        if (error) {
          errorFn(error)
        } else {
          successFn(result)
        }
      }) //connection.query()
  }, //insert()

  update: function(member, successFn, errorFn) {
    this.connection.query(
      'update memb set name=?, tel=?, email=? where mno=?',
      [member.name, member.tel, member.email, member.no],
      function(error, result) {
        if (error) {
          errorFn(error)
        } else {
          successFn(result)
        }
      })
  }, // update()

  delete: function(no, successFn, errorFn) {
    this.connection.query(
      'delete from memb where mno=?',
      [no],
      function(error, result) {
        if (error) {
          errorFn(error)
        } else {
          successFn(result)
        }
      }) //connection.query()
  }//delete()
}//module.exports
