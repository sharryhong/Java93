/* 주제: Node.js에서 제공하는, 내장된(built-in) 글로벌 객체
*/

"use strict"

// node가 실행하는 파일의 디렉토리 경로
console.log(__dirname)

// node가 실행하는 파일의 경로(디렉토리 포함)
console.log(__filename)

// 'path' 모듈 사용
const path = require('path')

// path.join은 여러 경로를 join시켜 하나의 경로로 만드는 것.
// 앞으로 파일 경로를 끊임없이 다루게된다.
console.log(path.join('c:/workspace/', 'javascript01/', 'step05/', 'test01.js'))
//
console.log(path.join(__dirname, 'test11.js')); // 슬래시 안해도 자동으로 해준다.
// 
console.log(path.join(__dirname, '../../electron01/step04/main.js' )); // 이렇게도 할 수 있다.
