/* mini Express 만들기
*/

// server start
var http = require('http')
// 서버 생성 완료
var server = http.createServer(function(request, response) {
  // 어떤 요청이 들어와도 응답함
  response.end()
})

module.exports = function() {
  return {
    // 기능 : 원래 있는 server.listen에 넘긴다.
    // cb(callback)은 포트번호로 서버가 정상적으로 실행되었을 때 호출될 함수
    listen(port, cb) {
      // 서버 시작
      server.listen(port, cb)
    }
  }
}
