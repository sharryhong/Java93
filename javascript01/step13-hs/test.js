var miniExpress = require('./mini-express')

var app = miniExpress()
// 8888포트번호로 서버 시작.
app.listen(8888, function() {
  console.log('2. 서버 실행');
})

app.get('/', function(request, response) {
  response.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'})
  response.end('<html> \
  <body> \
  <h1>안녕하세요!</h1> \
  </body> \
  </html>')
})
