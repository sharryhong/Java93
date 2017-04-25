/* HTTP 서버 만들기 - Single 스레드 방식
  => 한번에 한 클라이언트 요청만 처리
     즉,

  => 포트번호를 다르게하여 작은서버를 여러개 띄워서 처리한다. 
*/

const http = require('http')

const server = http.createServer(function(request, response) {
  console.log('클라이언트 요청이 들어왔음')
  // 요청이 들어오면 5초후에 응답완료
  setTimeout(function() {
    response.end()
  }, 5000)

})

server.listen(8888)
console.log("서버 실행 중..")
