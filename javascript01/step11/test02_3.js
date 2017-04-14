/* DBMS에 SQL명령 보내기 3) update : 데이터 갱신 명령
*/

const mysql = require('mysql')

var connection = mysql.createConnection({
  user     : 'webapp',
  password : '1111',
  database : 'webappdb'
})

connection.connect()

// name이 aaa인 사람의 tel을 바꿔라
connection.query('update memb set tel="222-2222" where name="aaa"', function (error, results) {
  console.log('결과를 가져왔음')
  if (error) throw error

  console.log(results)
})

connection.end()
console.log('MySQL 서버와의 연결 끊기가 예약되었음')
