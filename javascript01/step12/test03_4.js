/* 요청 URL 다루기 - url 분석기 사용 2
  query 문자열에서 특정 이름의 값만 추출하기
*/

const http = require('http')
const url = require('url')

const server = http.createServer(function(request, response) {
  if (request.url == '/favicon.ico') {
    response.end()
    return
  }
  console.log('클라이언트 요청이 들어왔음')

  console.log('url=', request.url)
  // url분석기를 통해 url분석하기
  // url 예) http://localhost:8888/aaa/bbb/ccc.html?v1=xxx&v2=yyyy&v3=zzzz
  // =>
  var urlInfo = url.parse(request.url, true) // aaa/bbb/ccc.html?v1=xxx&v2=yyyy&v3=zzzz
  console.log('query=', urlInfo.query) // { v1: 'xxx', v2: 'yyyy', v3: 'zzzz' }

  // query 문자열에서 v1, v2, v3 값을 따로 추출하기
  // 위에서 파싱할 때 true로 했을 때 이렇게 편하게 값을 추출할 수 있다.
  console.log('v1=', urlInfo.query.v1)
  console.log('v1=', urlInfo.query.v2)
  console.log('v1=', urlInfo.query.v3)

  response.writeHead(200, {
    'Content-type': 'text/plain;charset=UTF-8'
  })

  response.write('안녕하세요!')
  response.end()
})

server.listen(8888)
console.log("서버 실행 중..")
