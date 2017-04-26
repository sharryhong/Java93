// nodejs http모듈 필요
var http = require('http')
var url = require('url')

var getHandler = {}
// 서버 생성 완료
var server = http.createServer(function(request, response) {
  // method=get일 때 url query가 필요하기 때문에
  var urlInfo = url.parse(request.url, true)
  var handler = null
  if (request.method == 'GET') { // 대문자
    //
    handler = getHandler[urlInfo.pathname]
    // console.log('3' + handler)
    // 처음엔 undefined,
    // http://localhost:8888/들어갔을 때 handler에 test.js의 두번째 아규먼트인 함수
    request.query = urlInfo.query
  }
  if (handler) { // http://localhost:8888/들어갔을 때 실행
    console.log('???')
    handler(request, response)
  }
})

module.exports = function() {
  return {
    listen(port, cb) {
      // nodejs http : server.listen
      server.listen(port, cb)
    },
    get(url, cb) {
      // console.log('1' + url + cb); // test.js의 아규먼트들이 잘들어옴
      getHandler[url] = cb
      // test.js의 두번째 아규먼트인 함수가 getHandler객체의 url(/) 프로퍼티 값으로 됨
    }
  }
}
