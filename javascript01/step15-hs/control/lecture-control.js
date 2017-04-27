// 강의 정보를 다루는 서비스를 정의한다.
const express = require('express')
const datasource = require('../util/datasource')
const lectureDao = require('../dao/lecture-dao')
const lectureService = require('../service/lecture-service')
const router = express.Router()

const connection = datasource.getConnection()
lectureDao.setConnection(connection)
lectureService.setLectureDao(lectureDao)

router.get('/list.do', (request, response) => {
  var pageNo = 1, // 기본값 세팅
      pageSize = 3;
  if (request.query.pageNo) {
    pageNo = parseInt(request.query.pageNo)
  }
  if (request.query.pageSize) {
    pageSize = parseInt(request.query.pageSize)
  }
  lectureService.list(pageNo, pageSize, function(results, totalCount) {
    var lastPageNo = parseInt(totalCount / pageSize) + (((totalCount % pageSize) > 0) ? 1 : 0)
    response.render('lecture/index', {
      'data': results,
      'pageNo': pageNo,
      'nextPageNo': pageNo + 1,
      'prevPageNo': pageNo - 1,
      'disabledPrevBtn': (pageNo == 1) ? 'disabled' : '',
      'disabledNextBtn': (pageNo == lastPageNo) ? 'disabled' : ''
    })
  }, function(error) {
    response.render('error', {
      'message': '강의 목록 데이터를 가져오는 중 오류가 발생했습니다.'})
    console.log(error)
  })
})

router.get('/detail.do', function(request, response) {
  var no = parseInt(request.query.no)
  lectureService.detail(no, function(result) {
    // {'data': result, ...} : 넘길 데이터
    response.render('lecture/view', {
      'detail': true,
      'data': result,
      'checkedWork': (result.work == 'Y' ? 'checked' : '')
    })
  }, function(error) {
    response.render('error', {
      'message': '강의 데이터를 가져오는 중 오류가 발생했습니다.'})
    console.log(error)
  })
})

router.post('/update.do', function(request, response) {
  // 객체로 만들어서 전달하자.
  // post요청은 body라는 이름으로 꺼내온다.(express)
  lectureService.update({ // dao에서 원하는대로 보내야한다.
    no: request.body.no,
    working: (request.body.working == undefined ? 'N' : 'Y'),
    schoolName: request.body.schoolName,
    name: request.body.name,
    tel: request.body.tel,
    email: request.body.email,
    password: '1111'
  }, function(result) {
    console.log(result)
    // 웹브라우저에게 응답 내용을 보내지 않고, 대신 list.do로 다시 요청하라고 응답한다.
    // 그러면 웹브라우저는 list.do로 다시 요청한다.
    response.redirect('list.do')
  }, function(error) {
    response.render('error', {
      'message': '강의 목록 데이터를 가져오는 중 오류가 발생했습니다.'})
    console.log(error)
  })
})

router.get('/delete.do', function(request, response) {
  var no = parseInt(request.query.no)
  lectureService.delete(no, function(result) {
    response.redirect('list.do')
  }, function(error) {
    response.render('error', {
      'message': '강의 데이터를 삭제하는 중 오류가 발생했습니다.'})
    console.log(error)
  })
})

router.get('/form.do', function(request, response) {
  response.render('lecture/view')
})

router.post('/add.do', function(request, response) {
  lectureService.insert({
    working: (request.body.working == undefined ? 'N' : 'Y'),
    schoolName: request.body.schoolName,
    name: request.body.name,
    tel: request.body.tel,
    email: request.body.email,
    password: '1111'
  }, function(result) {
    response.redirect('list.do')
  }, function(error) {
    response.render('error', {
      'message': '강의 목록 데이터를 등록하는 중 오류가 발생했습니다.'})
    console.log(error)
  })
})

module.exports = router
