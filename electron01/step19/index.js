"use strict"

window.$ = window.jQuery = require('jquery')

const net = require('net')

var host = $('#host'),
    port = $('#port'),
    alias = $('#alias'),
    message = $('#message'),
    messageBox = $('#messageBox'),
    sendBtn = $('#sendBtn')
    
var myAlias = null

var socket = new net.Socket()

var buffer = ''
	
// 서버에서 data받으면
socket.on('data', (data) => {
	console.log(alias.val())
	buffer += data.toString() // 데이터 올때마다 버퍼에 담는다. 
    var value = null
	// 줄바꿈 코드를 찾아서 값 추출하기
	while (true) {
		var newLineIndex = buffer.indexOf('\n')
		if (newLineIndex < 0) return; // 줄바꿈코드가 없다면 : 아직 데이터를 덜 받았다.
		// 줄바꿈 코드가 있다면 예) aaa\nccc\n
		// \n코드 앞 문자열 추출 
		value = buffer.substring(0, newLineIndex)
		// \n코드 뒤 문자열은 다시 버퍼에 담기 
		buffer = buffer.substring(newLineIndex + 1)		
		if (value.length > 0) break; // \n코드 앞 문자열이 있으면 반복문을 멈춰서 처리
	}
	console.log(value)
	// 내꺼, 남의 꺼 class다르게 주어 다른 style적용하게 하기 위해
	$('<li>').addClass(value.startsWith(myAlias) ? "me" : "him").html(value).appendTo(messageBox)
	messageBox.scrollTop(messageBox.prop('scrollHeight'))
})

socket.on('error', (error) => {
	alert(error.message)
})

$('#connectBtn').click(() => {
	socket.connect(parseInt(port.val()), host.val(), () => {
		socket.write(alias.val() + '\n')
		// 연결할 때 서버에 클라이언트의 별명보관
		myAlias = '[' + alias.val()
	})
	
})

sendBtn.click(() => {
	socket.write(message.val() + '\n')
	message.val('')
})

message.keyup((e) => {
	if (e.keyCode == 0x0d) {
		// .replace('\n', '') 한 이유 : 엔터 안넘어가게
		var text = message.val().replace('\n', '').replace('\r', '')
		message.val(text)
		sendBtn.click() // 클릭이벤트를 발생시킨다. sendBtn.click(() => {}가 실행된다.
	}
})
