/* 요청 URL 다루기 - Quiz!
  계산기 서비스를 구현하라!
  요청 예) http://localhost:8888/calculator?a=100&b=200&op=-
  출력결과 예) 100 - 200 = -100
  op에 들어갈 연산자: +, -, *, /, %
*/

const http = require('http')
const url = require('url')

const server = http.createServer(function(request, response) {
  if (request.url == '/favicon.ico') {
    response.end()
    return
  }

  console.log('클라이언트 요청이 들어왔네!')

  response.writeHead(200, {
    'Content-type': 'text/plain;charset=UTF-8'
  })

  var urlInfo = url.parse(request.url, true)
  console.log('query=', urlInfo.query)

  var a = urlInfo.query.a,
      b = urlInfo.query.b,
      op = urlInfo.query.op,
      result = 0

  switch (op) {
    case '+':
      result = a + b
      break;
    case '-':
      result = a - b
      break;
    case '*':
      result = a * b
      break;
    case '/':
      result = a / b
      break;
    case '%':
      result = a % b
      break;
  }

  console.log(a + op + b + '=' + result)
  response.write(a + op + b + '=' + result)

  response.end()
})

server.listen(8888)
console.log("서버 실행 중..")
