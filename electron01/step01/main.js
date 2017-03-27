/* 주제 : Electron 모듈 사용하기 (최소 필요사항)
-
*/

const {app} = require('electron') // node.js에서 등록된 모듈(npm으로 설치한 모듈)이기 때문에 모듈 이름만 지정한 것임

// 윈도우 객체(의 주소)를 저장할 변수
let win

//
app.on('ready', createWindow)

function createWindow () {
  console.log('윈도우 생성하기');
}
