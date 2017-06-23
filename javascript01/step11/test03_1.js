/*
*/

const mysql = require('mysql')

var connection = mysql.createConnection({
  user     : 'webapp',
  password : '1111',
  database : 'webappdb'
})

connection.connect()

connection.query('insert into memb(name, email, tel, pwd) values(?,?,?, password(?))', ["오호라", "oh@test.com", "111-1111", "1111"],
  function (error, results) {
  console.log('결과를 가져왔음')
  if (error) throw error

  console.log(results)
  // results에 데이터가 들어간다. 
  // 자동증가한 값이 insertId값으로 들어간다.
})

connection.end()
console.log('MySQL 서버와의 연결 끊기가 예약되었음')
