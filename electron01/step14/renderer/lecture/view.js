"use strict"
window.$ = window.jQuery = require('jquery')

var lectureService = require('electron').remote.getGlobal('lectureService')

var fiNo = $('#fi-no'),
    fiTitle = $('#fi-title'),
    fiDescription = $('#fi-description'),
    fiStartdate = $('#fi-startdate'),
    fiEnddate = $('#fi-enddate'),
    fiQuantity = $('#fi-quantity'),
    fiPrice = $('#fi-price'),
    fiTotalhours = $('#fi-totalhours'),
    fiManager = $('#fi-manager');

// 추가 버튼 눌렀을 때 view.html
if (location.search == "") {
  $('.bit-view').css('display', 'none')
  $('.bit-new').css('display', '')

  $('#add-btn').click(function() {
    lectureService.insert(
      {
        titl: fiTitle.val(),
        dscp: fiDescription.val(),
        sdt: fiStartdate.val(),
        edt: fiEnddate.val(),
        qty: fiQuantity.val(),
        pric: fiPrice.val(),
        thrs: fiTotalhours.val()
      },
      function() {
        location.href = 'index.html'
      },
      function(error) {
        alert('강의 등록 중 오류 발생!')
        throw error;
    }) //insertMember()
  }) // click()

} else { // 기존 사용자 정보를 가져오는 view.html
  $('.bit-new').css('display', 'none')
  var no = location.search.substring(1).split('=')[1]

  lectureService.detail(no,
    function(result, managers) {
      var lecture = result
      var managers = managers
      console.log(managers)
      var startDay = new Date(lecture.sdt)
      var endDay = new Date(lecture.edt)
      fiNo.text(lecture.lno)
      fiTitle.val(lecture.titl)
      fiDescription.val(lecture.dscp)
      fiStartdate.val(startDay.getFullYear() +"-"+ (startDay.getMonth()+1) +"-"+ startDay.getDate())
      fiEnddate.val(endDay.getFullYear() +"-"+ (endDay.getMonth()+1) +"-"+ endDay.getDate())
      fiQuantity.val(lecture.qty)
      fiPrice.val(lecture.pric)
      fiTotalhours.val(lecture.thrs)
      for (var i = 0; i < managers.length; i++) {
        let m = managers[i]
        console.log(m)
        $("<option>").html(m.name).appendTo(fiManager)
      }
    },
    function(error) {
      alert('강의 데이터 가져오는 중 오류 발생!')
      throw error
  })

  $('#upd-btn').click(function() {
    lectureService.update(
      {
        "no": no,
        "titl": fiTitle.val(),
        "dscp": fiDescription.val(),
        "sdt": fiStartdate.val(),
        "edt": fiEnddate.val(),
        "qty": fiQuantity.val(),
        "pric": fiPrice.val(),
        "thrs": fiTotalhours.val()
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
    lectureService.delete(no,
      function(result) {
        location.href = 'index.html'
      },
      function(error) {
        alert('강의 기본 데이터 삭제 중 오류 발생!')
        throw error;
    })
  }) // click()
} // else

$('#lst-btn').click(function() {
  location.href = "index.html"
})
