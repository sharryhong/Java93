var miniExpress = require('./mini-express')

var app = miniExpress()
// 8888포트번호로 서버 시작.
app.listen(8888, function() {
  console.log('서버 실행');
})
