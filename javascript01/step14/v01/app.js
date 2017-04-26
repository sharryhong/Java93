/* Express 프레임워크 적용
*/
var express = require('express')

//
var bodyParser = require('body-parser')

var app = express()
// public폴더가 static resource가 있는 폴더이다.
app.use(express.static('public'))
//
app.use(bodyParser.urlencoded({ extended: false }))

app.get('/get_test.do', function(request, response) {
  response.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'})
  response.write('GET 요청 처리!\n')
  response.write('name=' + request.query.name + '\n')
  response.write('age=' + request.query.age + '\n')
  response.write('tel=' + request.query.tel + '\n')
  response.end()
})

app.post('/post_test.do', function(request, response) {
  response.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'})
  response.write('POST 요청 처리!\n')
  response.write('name=' + request.body.name + '\n')
  response.write('age=' + request.body.age + '\n')
  response.write('tel=' + request.body.tel + '\n')
  response.end()
})

app.listen(8888, function() {
  console.log('서버가 시작되었습니다.')
})
