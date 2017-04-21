// connection 객체를 준비
"use strict"
const mysql = require('mysql')
const con = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})
con.connect()

module.exports = {
  // 내가 만든 객체 리턴
  getConnection() {
    return con
  }
}

/* 이렇게 할 수도 있다. 기존에 exports라는 객체가 있다.
module.exports.getConnection = function() {
  return con
}
*/
