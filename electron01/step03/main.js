/* 주제 : 생성된 윈도우에 HTML 파일 로딩하기
-
*/

const {app, BrowserWindow} = require('electron')

const path = require('path')

let win

app.on('ready', createWindow)

// app.on('window-all-closed', quitApp)

function createWindow () {
  win = new BrowserWindow({width: 500, height: 400})
  win.loadURL('file:///C:/workspace/electron01/step03/index.html')
  // win.loadURL('http://www.naver.com/') // 된다. 크롬 브라우저이기 때문
}

// function quitApp() {
//   console.log('애플리케이션 종료하기');
// }
