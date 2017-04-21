/* 주제:
 */
const {app, BrowserWindow} = require('electron')
const path = require('path')
const url = require('url')

const datasource = require('./util/datasource')
const connection = datasource.getConnection()

// 데이터 부분
const studentDao = require('./dao/student-dao')
studentDao.setConnection(connection)
const memberDao = require('./dao/member-dao')
memberDao.setConnection(connection)

// UI 부분
const studentService = require('./service/student-service')
studentService.setMemberDao(memberDao) // 데이터 부분을 넘겨준다.
studentService.setStudentDao(studentDao) // 데이터 부분을 넘겨준다. 

// 글로벌 변수로 지정
global.studentService = studentService

let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWindow({width: 800, height: 600})
  win.loadURL(url.format({
    protocol: 'file:',
    pathname: path.join(__dirname, '../renderer/index.html'),
    slashes: true
  }))
  //win.webContents.openDevTools() // 웹브라우저의 개발도구창을 띄운다.

}
