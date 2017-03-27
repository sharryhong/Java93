/* 주제 : HTML 파일의 URL 경로를 쉽게 만들기
-
*/

const {app, BrowserWindow} = require('electron')
const path = require('path')

//
const url = require('url')

let win

app.on('ready', createWindow)

// console.log(__dirname) // 현재 경로

function createWindow () {
  win = new BrowserWindow({width: 500, height: 400})
  // 절대경로의 문제점 : 위치 옮기면 수정해야한다.
  // 1) win.loadURL('file:///C:/workspace/electron01/step03/index.html')
  // 상대경로로 수정 : const path = require('path') 쓰기 전
  // 2) win.loadURL('file://' + __dirname + '/index.html') // 문자열의 더하기일 뿐이다.
  // 위 방법의 단점 : 슬래시를 붙일 것인가 말 것인가.
  // javascript01/step06/test11.js참고
  // 3) win.loadURL(path.join('file://', __dirname, 'index.html'))
  // 그런데 file:다음에 슬래시슬래시(//)가 안오네? (실행은되지만)
  //
  // 개발자답게 제대로 된 경로로 바꾸자.
  // 4) htmlURL : 쓸데없이 쓴 것. 나중에 유지보수 어렵다.
  // var htmlURL = url.format({ // url모듈의 도움을 받자. 경로를 JavaScript객체로 넘긴다.
  //   protocol: 'file:',
  //   pathname: path.join(__dirname, '/index.html'),
  //   slashes: true // file:/// 붙는다. 안하면 // 두개 붙음. 3개가 맞음.
  // })
  // console.log(htmlURL)
  // 5) 실무에서는 이렇게 쓴다.
  win.loadURL(url.format({ // url모듈의 도움을 받자. 경로를 JavaScript객체로 넘긴다.
    protocol: 'file:',
    pathname: path.join(__dirname, '/index.html'),
    slashes: true // file:/// 붙는다. 안하면 // 두개 붙음. 3개가 맞음.)
  }))
}

// console.log(path.join('file://', __dirname, 'index.html')); // 확인해보기
