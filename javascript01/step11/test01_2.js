/* DBMS에 SQL명령 보내기
*/

const mysql = require('mysql')

var connection = mysql.createConnection({
  user     : 'webapp',
  password : '1111',
  database : 'webappdb'
})
console.log('MySQL 서버에 연결할 도구 생성완료')

connection.connect()
console.log('MySQL 서버와 연결됨')

// DBMS에 SQL명령 보내기
// 매개변수 1 : 명령어쓰고, 콜백함수처리 
connection.query('select * from memb', function (error, results) {
  console.log('결과를 가져왔음')
})

connection.end()
console.log('MySQL 서버와의 연결 끊기가 예약되었음')
