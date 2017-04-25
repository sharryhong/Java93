/* HTTP 서버 만들기 - 서버 띄우기 */

// 기본 제공 모듈
// 1) http 모듈 로딩
const http = require('http')

// 2) HttpServer 객체 생성
// => 파라미터는 클라이언트 요청이 들어왔을 때 호출될 함수
// 즉, 클라이언트에서 요청이 들어오면 파라미터로 넘긴 함수를 호출한다.
const server = http.createServer(function(request, response) {
  // client가 request했을 때
  // 요청에 관련된 객체, 응답에 관련된 객체가 넘어온다.(파라미터로)
  console.log('클라이언트 요청이 들어왔음')
})

// 3) HttpServer 실행
server.listen(8080)
console.log("서버 실행 중..")
