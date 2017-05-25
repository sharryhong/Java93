"use strict"
window.$ = window.jQuery = require('jquery')

var managerService = require('electron').remote.getGlobal('managerService')

var fiNo = $('#fi-no'),
    fiEmail = $('#fi-email'),
    fiPassword = $('#fi-password'),
    fiName = $('#fi-name'),
    fiPosi = $('#fi-posi'),
    fiTel = $('#fi-tel'),
    fiFax = $('#fi-fax'),
    fiPath = $('#fi-path');

// 추가 버튼 눌렀을 때 view.html
if (location.search == "") {
  $('.bit-view').css('display', 'none')
  $('.bit-new').css('display', '')

  $('#add-btn').click(function() {
    managerService.insert(
      {
        email: fiEmail.val(),
        password: fiPassword.val(),
        name: fiName.val(),
        posi: fiPosi.val(),
        tel: fiTel.val(),
        fax: fiFax.val(),
        path: fiPath.val()
      },
      function() {
        location.href = 'index.html'
      },
      function(error) {
        alert('회원 등록 중 오류 발생!')
        throw error;
    }) //insertMember()
  }) // click()

} else { // 기존 사용자 정보를 가져오는 view.html
  $('.bit-new').css('display', 'none')
  var no = location.search.substring(1).split('=')[1]

  managerService.detail(no,
    function(result) {
      var manager = result
      fiNo.text(manager.mno)
      fiEmail.val(manager.email)
      fiName.val(manager.name)
      fiPosi.val(manager.posi)
      fiTel.val(manager.tel)
      fiFax.val(manager.fax)
      fiPath.val(manager.path)
    },
    function(error) {
      alert('매니저 데이터 가져오는 중 오류 발생!')
      throw error
  })

  $('#upd-btn').click(function() {
    managerService.update(
      {
        "no": no,
        "email": fiEmail.val(),
        "password": fiPassword.val(),
        "name": fiName.val(),
        "posi": fiPosi.val(),
        "tel": fiTel.val(),
        "fax": fiFax.val(),
        "path": fiPath.val()
      },
      function(result) {
        alert('변경하였습니다.')
      },
      function(error) {
        alert('회원 기본 데이터 변경 중 오류 발생!')
        throw error;
    })//update()
  }) //click()

  $('#del-btn').click(function() {
    managerService.delete(no,
      function(result) {
        location.href = 'index.html'
      },
      function(error) {
        alert('강사 기본 데이터 삭제 중 오류 발생!')
        throw error;
    })
  }) // click()
} // else

$('#lst-btn').click(function() {
  location.href = "index.html"
})
