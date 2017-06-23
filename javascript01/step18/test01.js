// Echo 클라이언트 만들기 : nodeJS
const net = require('net') // net모듈 로딩

// 1) 소켓 객체 준비
const socket = new net.Socket()

// 2) 서버에 연결
socket.connect(8888, 'localhost', function() { 
	console.log('=> 연결되었음')
	socket.write('hello~\n')  // 연결되면 실행
	console.log('=> 서버에 데이터 보냈음')
})

// 3) 데이터를 읽었을 때 호출될 리스너 등록
// => 서버에서 데이터를 보내면 'data' 이벤트가 발생한다.
// 이 이벤트가 발생하면 등록된 함수 실행. (자바스크립트가 비동기이기때문에 이렇게 작성)
socket.on('data', function(data) {
	console.log(data.toString())
	socket.destroy() // data출력 후 서버와의 연결끊기
})

// 4) 소켓을 닫으면 서버와의 연결이 끊어졌음을 알리는 'close' 이벤트 발생 
// => 이 이벤트가 발생하면 등록된 함수 실행
socket.on('close', function() {
	console.log('연결끊김')
})