/* Express 프레임워크 적용
*/
var express = require('express')
var bodyParser = require('body-parser')
var path = require('path')
//
var cons = require('consolidate');

var app = express()
app.use(express.static('public'))
app.use(bodyParser.urlencoded({ extended: false }))
//
var router = require('./aa');
// aa폴더는 router가 처리
app.use('/aa', router)
//
app.engine('html', cons.handlebars)
//
app.set('view engine', 'html')
//
app.set('views', path.join(__dirname, '/templates'))
// test.do url이면 test.html 렌더링(템플릿엔진 통한)한 걸 쓰겠다
app.get('/test.do', function(request, response) {
  response.render('test', {name: '홍길동'})
})

app.get('/test2.do', function(request, response) {
  response.render('test2', {name: ['홍길동', '임꺽정', '유관순']})
})

app.get('/test3.do', function(request, response) {
  response.render('d/test3', {name: ['zz', '임꺽정', '유관순']})
})


app.listen(8888, function() {
  console.log('서버가 시작되었습니다.')
})
