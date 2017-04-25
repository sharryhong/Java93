/* 클라이언트로 출력하기 */

const http = require('http')

const server = http.createServer(function(request, response) {
  console.log('클라이언트 요청이 들어왔음')

  response.write('Hello, World!')
  response.write('안녕하세요!')
  response.end()
})

server.listen(8888)
console.log("서버 실행 중..")

/* 문제점
*/
