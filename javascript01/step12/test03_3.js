/* 요청 URL 다루기 - url 분석기 사용
  기타 요청 정보 다루기
*/

const http = require('http')
// url 분석기가 들어있는 모듈 로딩
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
  var urlInfo = url.parse(request.url) // aaa/bbb/ccc.html?v1=xxx&v2=yyyy&v3=zzzz
  console.log('href=', urlInfo.href) // aaa/bbb/ccc.html?v1=xxx&v2=yyyy&v3=zzzz
  console.log('pathname=', urlInfo.pathname) // aaa/bbb/ccc.html // ?앞값
  console.log('search=', urlInfo.search) // ?v1=xxx&v2=yyyy&v3=zzzz // ?포함한 뒤값
  console.log('query=', urlInfo.query) // v1=xxx&v2=yyyy&v3=zzzz // ?제외한 뒤값

  response.writeHead(200, {
    'Content-type': 'text/plain;charset=UTF-8'
  })

  response.write('안녕하세요!')
  response.end()
})

server.listen(8888)
console.log("서버 실행 중..")
