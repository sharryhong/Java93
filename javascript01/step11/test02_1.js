/* DBMS에 SQL명령 보내기 1) select ~ from  : 데이터 조회 명령
*/

const mysql = require('mysql')

var connection = mysql.createConnection({
  user     : 'webapp',
  password : '1111',
  database : 'webappdb'
})

connection.connect()

connection.query('select mno, name, tel from memb', function (error, results) { // error가 안들어오면 undefined
  console.log('결과를 가져왔음')
  if (error) throw error
  // results에 있는 값을 한 개씩 꺼내 출력
  for (var row of results) {
    console.log(row.mno, row.name, row.tel)
  }
})

connection.end()
console.log('MySQL 서버와의 연결 끊기가 예약되었음')
 
