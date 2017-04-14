/* DBMS에 SQL명령 보내기 2) insert : 데이터 추가 명령
*/

const mysql = require('mysql')

var connection = mysql.createConnection({
  user     : 'webapp',
  password : '1111',
  database : 'webappdb'
})

connection.connect()

// 순서 상관없다.
// ' + ' 는 줄바꿈하기 위함
// 비번은 암호화
connection.query('insert into memb(name, email, tel, pwd)' +
  ' values("aaa2", "aaa2@test.com", "111-1111", password("1111"))', function (error, results) { // error가 안들어오면 undefined
  console.log('결과를 가져왔음')
  if (error) throw error

  console.log(results)
})

connection.end()
console.log('MySQL 서버와의 연결 끊기가 예약되었음')
