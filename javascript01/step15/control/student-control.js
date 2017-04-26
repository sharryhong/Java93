// 학생 정보를 다루는 서비스를 정의한다.
const express = require('express')
const datasource = require('../util/datasource')
const memberDao = require('../dao/member-dao')
const studentDao = require('../dao/student-dao')
const studentService = require('../service/student-service')
const router = express.Router()

const connection = datasource.getConnection()
memberDao.setConnection(connection)
studentDao.setConnection(connection)
studentService.setMemberDao(memberDao)
studentService.setStudentDao(studentDao)

router.get('/list.do', (request, response) => {
  studentService.list(1, function(results, totalCount) {
    response.render('student/index', {data: results})
  }, function(error) {
    response.end('오류!')
    throw error // server 끝남
  })
})

module.exports = router
