/* 요청 URL 다루기 - Quiz! 2
=> 사용자로부터 페이지 번호와 개수를 입력 받아 학생 목록을 html 페이지로 출력하시오.
=> 요청 예) http://localhost:8888/student/list.do?pageNo=2&pageSize=3
=> 출력 예) (기존의 학생 목록 출력을 참고하여) 간단히 테이블로 출력하라. 이전, 다음페이지 안붙임
*/

const http = require('http')
const url = require('url')

const datasource = require('./datasource')
const studentDao = require('./student-dao')
const studentService = require('./student-service')
const connection = datasource.getConnection()
studentDao.setConnection(connection)
studentService.setStudentDao(studentDao)

const server = http.createServer(function(request, response) {
  if (request.url == '/favicon.ico') {
    response.end()
    return
  }

  // 1_ url 분석기 실행
  var urlInfo = url.parse(request.url, true)

  if (urlInfo.pathname != '/student/list.do') {
    response.writeHead(404, {
      'Content-type': 'text/plain;charset=UTF-8'
    })
    response.end('잘못된 url입니다.')
    return
  }

  var pageNo = parseInt(urlInfo.query.pageNo),
      pageSize = parseInt(urlInfo.query.pageSize)

  response.writeHead(200, {
    'Content-type': 'text/html;charset=UTF-8'
  })

  response.write(
    '<html>\
    <head>\
      <title>학생목록</title>\
    </head>\
    <body>')
  response.write('<h1>학생목록</h1>')

  studentService.list(pageNo, pageSize, function(results) {
    response.write(
      '<table border="1">\
      <thead>\
      <tr><th>번호</th><th>이름</th><th>이메일</th><th>전화</th><th>직장인</th></tr>\
      </thead>\
      <tbody>' )
    for (var r of results) {
      response.write('<tr><td>' + r.mno + '</td>')
      response.write('<td>' + r.name + '</td>')
      response.write('<td>' + r.email + '</td>')
      response.write('<td>' + r.tel + '</td>')
      response.write('<td>' + r.work + '</td></tr>')
    }
    response.write('</tbody></table>\
    </body></html>')
    response.end() // for문이 모두 끝난 후 HTTP 응답을 완료. 클라이언트에게 응답을 완료한다.
  }, function(error) {
    response.write('DB 오류')
    response.write('</body></html>')
    response.end() // error일 때도 해줘야한다.
    throw error; // error의 상세정보를 출력
  })


})

server.listen(8888)
console.log("서버 실행 중..")
