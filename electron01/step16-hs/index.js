"use strict"

window.$ = window.jQuery = require('jquery')

const net = require('net')

var host = $('#host'),
    port = $('#port'),
    connectBtn = $('#connectBtn'),
    closeBtn = $('#closeBtn'),
    msgBox = $('#msgBox'),
    nickname = $('#nickname'),
    showMsg = $('#showMsg')

closeBtn.css('display', 'none')

var socket = new net.Socket()

// 정상적으로 연결되면
socket.on('connect', () => {
	connectBtn.css('display', 'none')
	closeBtn.css('display', '')
})

var buffer = ''
	
// 서버에서 data받으면
socket.on('data', (data) => {
//	buffer += data.toString() // 데이터 올때마다 버퍼에 담는다. 
//    var value = null
	// 줄바꿈 코드를 찾아서 값 추출하기
//	while (true) {
//		var newLineIndex = buffer.indexOf('\n')
//		if (newLineIndex < 0) return; // 줄바꿈코드가 없다면 : 아직 데이터를 덜 받았다.
		// 줄바꿈 코드가 있다면 예) aaa\nccc\n
		// \n코드 앞 문자열 추출 
//		value = buffer.substring(0, newLineIndex)
		// \n코드 뒤 문자열은 다시 버퍼에 담기 
//		buffer = buffer.substring(newLineIndex + 1)		
//		if (value.length > 0) break; // \n코드 앞 문자열이 있으면 반복문을 멈춰서 처리
//	}
//	console.log(value)	
//	showMsg.val(value)
//	showMsg.val(data.toString())
	showMsg.append("<p>"+ data.toString() +"</p>")
})

socket.on('error', (error) => {
	alert(error.message)
})

// 서버와의 연결이 끊어지면 (socket.distroy() 되면)
socket.on('close', () => {
	alert('끊었습니다.')
})

connectBtn.click(() => {
	socket.connect(parseInt(port.val()), host.val())
})

closeBtn.click(() => {
	socket.destroy() // 소켓 끊기 (맥에선 잘 안된다고 한다)
	socket.end() // 연결 끊기
	connectBtn.css('display', '')
	closeBtn.css('display', 'none')
})

var obj = null;

$('#sendBtn').click(() => {
	obj = {
		msgBox: msgBox.val(),
		nickname: nickname.val()
	}
	console.log(JSON.stringify(obj)) // json파일에 문자열화 시켜서 보내자.
	// 서버에 보내자.
	socket.write(JSON.stringify(obj) + '\n')
})

