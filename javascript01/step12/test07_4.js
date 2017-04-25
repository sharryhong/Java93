/* 기존 코드에 새 서비스 추가 2
=>
*/

const http = require('http')
const url = require('url')
const qs = require('querystring')

// handlerMapping의미 : 서비스를 연결.. Spring에서 용어가 나온다.
var handlerMapping = {}

// handlerMapping객체에 메소드들 추가 
// 객체에 프로퍼티명 추가할 땐 점(.)으로 하면되지만,
// 지금처럼 특수문자가 있을 경우에는 []로 해야한다.
handlerMapping['/get.do'] = (request, response) => {
  response.write('GET 요청 처리 \n')
  response.write('name=' + request.query.name + '\n')
  response.write('age=' + request.query.age + '\n')
  response.write('tel=' + request.query.tel + '\n')
  response.end()
}

handlerMapping['/post.do'] = (request, response) => {
  var buf = ''
  request.on('data', (data) => {
    buf += data
  })
  request.on('end', () => {
    var params = qs.parse(buf)
    response.write('POST 요청 처리 \n')
    response.write('name=' + params.name + '\n')
    response.write('age=' + params.age + '\n')
    response.write('tel=' + params.tel + '\n')
    response.end()
  })
}

handlerMapping['/hello.do'] = (request, response) => {
  response.write('안녕하슈')
  response.end()
}

function notFound(request, response) {
  response.write('해당 url을 지원하지 않습니다.')
  response.end()
}

const server = http.createServer(function(request, response) {
  var urlInfo = url.parse(request.url, true)

  // 함수내에서 query를 쓰기 위해. get요청일때만 필요하다.
  if (request.method == 'GET') {
    request.query = urlInfo.query
  }

  response.writeHead(200, {
    'Content-Type' : 'text/plain;charset=UTF-8'
  })

  // 앞으로 서비스를 추가하더라도 아래 조건문을 손댈 필요가 없다.
  var fn = handlerMapping[urlInfo.pathname]
  if (fn) {  // fn이 있다면
    fn(request, response)
  } else {
    notFound(request, response)
  }
})

server.listen(8888)

console.log("서버 실행 중...")
