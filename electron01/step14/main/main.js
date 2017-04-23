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
const teacherDao = require('./dao/teacher-dao')
teacherDao.setConnection(connection)
const managerDao = require('./dao/manager-dao')
managerDao.setConnection(connection)
const memberDao = require('./dao/member-dao')
memberDao.setConnection(connection)
const lectureDao = require('./dao/lecture-dao')
lectureDao.setConnection(connection)

const studentService = require('./service/student-service')
studentService.setMemberDao(memberDao)
studentService.setStudentDao(studentDao)

const teacherService = require('./service/teacher-service')
teacherService.setMemberDao(memberDao)
teacherService.setTeacherDao(teacherDao)

const managerService = require('./service/manager-service')
managerService.setMemberDao(memberDao)
managerService.setManagerDao(managerDao)

const lectureService = require('./service/lecture-service')
lectureService.setLectureDao(lectureDao)
lectureService.setManagerDao(managerDao)
// classroomService.setClassroomDao(classroomDao)

// 글로벌 변수로 지정
global.studentService = studentService
global.teacherService = teacherService
global.managerService = managerService
global.lectureService = lectureService

let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWindow({width: 1200, height: 900})
  win.loadURL(url.format({
    protocol: 'file:',
    pathname: path.join(__dirname, '../renderer/index.html'),
    slashes: true
  }))
  win.webContents.openDevTools() // 웹브라우저의 개발도구창을 띄운다.

}
