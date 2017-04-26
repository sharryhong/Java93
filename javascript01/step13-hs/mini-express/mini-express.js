// nodejs http모듈 필요
var http = require('http')
var url = require('url')
var path = require('path')
var fs = require('fs')
// post요청시 querystring모듈 필요
var qs = require('querystring')
// get요청일 때 담을 객체
var getHandler = {}
// post요청일 때 담을 객체
var postHandler = {}
// 없는 url일 때
function notFound(request, response) {
  response.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'})
  fs.readFile(path.join(__dirname, './html/http-404.html'), function(err, data) {
    if (err) throw error
    response.end(data)
  })
}
// 함수로 코드 분리
function findHandler(method, servicePath) {
  // console.log(method + servicePath);
  if (method == 'GET') {
    // getHandler 객체에 프로퍼티 추가
    return getHandler[servicePath]
  } else if (method == 'POST') {
    return getHandler[servicePath]
  }
  return null
}

// 서버 생성 완료
var server = http.createServer(function(request, response) {
  // method=get일 때 url query가 필요하기 때문에
  var urlInfo = url.parse(request.url, true)
  var handler = findHandler(request.method, urlInfo.pathname)
  // console.log('..'+findHandler(request.method, urlInfo.pathname));
  if (handler) {
    if (request.method == 'GET') {
      // console.log('getHandler:' +getHandler[urlInfo.pathname]);
      request.query = urlInfo.query
      handler(request, response)
  /* getHandler = {
      [urlInfo.pathname] : function(request, response) {...} => test.js의 두번째 아규먼트인 함수가 들어있다. 그걸 실행시켜라.
    }
  */
    } else if (request.method == 'POST') {
      var queryString = ''
      request.on('data', function(data) {
        queryString += data
      })
      // 쿼리스트링 데이터 다 받으면 실행
      request.on('end', function() {
        request.query = qs.parse(queryString)
        handler(request, response)
      })
    }
  } else {
    notFound(request, response)
  }
})

module.exports = function() {
  return {
    get(url, cb) {
      // console.log('1' + url + cb); // test.js의 아규먼트들이 잘들어옴
      getHandler[url] = cb
      // test.js의 두번째 아규먼트인 함수가 getHandler객체의 url(/) 프로퍼티 값으로 됨
    },
    post(url, cb) {
      getHandler[url] = cb
    },
    listen(port, cb) {
      // nodejs http : server.listen
      server.listen(port, cb)
    }
  }
}
