// 폴더분리한 후 해당 폴더로 가서 모듈가져오기
var miniExpress = require('./mini-express/mini-express')

var app = miniExpress()
// static source가 있는 폴더 지정하기
app.use('static_dir', './static')

app.get('/get_test.do', function(request, response) {
  response.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'})
  response.write('GET 요청 처리!')
  response.write('name=' + request.query.name)
  response.write('age=' + request.query.age)
  response.write('tel=' + request.query.tel)
  response.end()
})

app.post('/post_test.do', function(request, response) {
  response.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'})
  response.write('POST 요청 처리!')
  response.write('name=' + request.query.name)
  response.write('age=' + request.query.age)
  response.write('tel=' + request.query.tel)
  response.end()
})
app.listen(8888, function() {
  console.log('2. 서버 실행');
})
