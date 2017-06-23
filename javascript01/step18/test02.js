// Echo 서버 만들기 : nodeJS
const net = require('net') // net모듈 로딩

// 1) 서버 객체 준비
// socket : java에서 .accept() 했을 때 소켓 객체 넘어오는 것과 같다. 
const server = net.createServer((socket) => { // 클라이언트가 접속하면 호출됨
	console.log('=> 클라이언트가 연결되었습니다.')
	
	socket.on('data', (data) => {
		socket.write('[메롱]' + data.toString())
		socket.destroy()  // 한번 응답하고 끝내자.
	})
}) 

// 2) 서버를 시작시킨다.
server.listen(8888, () => {
  console.log('서버 실행 중...!')
});
