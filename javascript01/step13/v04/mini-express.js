/* mini Express 만들기
*/

var http = require('http')
// url분석기 필요하므로 url모듈 필요
var url = require('url')
var path = require('path')
var fs = require('fs')
var getHandler = {}
var postHandler = {}

function notFound(request, response) {
  // 헤더정보
  response.writeHead(200, {
    'Content-Type' : 'text/html;charset=UTF-8'
  })
  fs.readFile(path.join(__dirname, './html/http-404.html'), function(err, data) {
    if (err) throw err
    // 성공적으로 읽어왔으면 실행되는 함수
    // data에는 경로 파일에서 들어온 데이터가 들어있다.
    response.end(data)
  })
}

var server = http.createServer(function(request, response) {
  // url분석
  var urlInfo = url.parse(request.url, true)
  var handler = null
  if (request.method == 'GET') { // 대문자로 들어있음
    handler = getHandler[urlInfo.pathname]
    // request에는 query가 없으므로 담아준다.
    request.query = urlInfo.query
  } else if (request.method == 'POST') {
    handler = getHandler[urlInfo.pathname]
  }
  // 찾았으면
  if (handler) {
    handler(request, response)
  } else {
    notFound(request, response)
  }
})

module.exports = function() {
  return {
    // 주어진 url로 GET요청이 들어왔을 때 호출될 함수를 등록한다.
    get(url, handler) {
      // getHandler객체에 url프로퍼티명으로 handler함수 등록
      getHandler[url] = handler
    },
    // 주어진 url로 POST요청이 들어왔을 때 호출될 함수를 등록한다.
    post(url, handler) {
      // postHandler객체에 url프로퍼티명으로 handler함수 등록
      postHandler[url] = handler
    },
    // 웹서버를 시작시킨다.
    listen(port, cb) {
      server.listen(port, cb)
    }
  }
}
