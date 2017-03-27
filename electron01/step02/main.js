/* 주제 : 윈도우 생성하기
-
*/

//
const {app, BrowserWindow} = require('electron')

let win

//
app.on('ready', createWindow)

//
function createWindow () {
  // Create the browser window.
  // BrowserWindow는 생성자함수구나
  win = new BrowserWindow({width: 500, height: 400})
}
