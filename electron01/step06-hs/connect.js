// mysql 모듈준비
const mysql = require('mysql')
// connection 객체 만들기
const connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})
// mysql db접속
connection.connect()
