/* MVC패턴의 Control담당 */
"use strict"
window.$ = window.jQuery = require('jquery')

var lectureService = require('electron').remote.getGlobal('lectureService')

var tbody = $('#lecture-tbl > tbody')

displayList(1)

$('#add-btn').click(function() {
  location.href = 'view.html'
})

$('#prev-btn').click(function() {
  var currPageNo = parseInt($('#page-no').text())
  displayList(currPageNo - 1)
})

$('#next-btn').click(function() {
  var currPageNo = parseInt($('#page-no').text())
  displayList(currPageNo + 1)
})

function displayList(pageNo) {
  lectureService.list(
    pageNo,
    // service에서 처리한 값을 받는다.
    // results엔 selectList에서 처리한 데이터객체, totalCount엔 result[0].cnt인 row갯수가 들어온다.
    function(results, totalCount) {
      tbody.html('');
      for (var i = 0; i < 3; i++) {
        if (i < results.length) {
          let s = results[i]
          let startDay = new Date(s.sdt)
          let endDay = new Date(s.edt)
          $("<tr>").html("<td>" + s.lno +
          "</td><td><a href='#' data-no='" + s.lno + "' class='view-link'>" + s.titl +
          "</a></td><td>" + s.dscp +
          "</td><td>" + startDay.getFullYear() +"년 "+ (startDay.getMonth()+1) +"월 "+ startDay.getDate()+"일" +
          "</td><td>" + endDay.getFullYear() +"년 "+ (endDay.getMonth()+1) +"월 "+ endDay.getDate()+"일" +
          "</td><td>" + s.qty +
          "</td><td>" + s.pric +
          "</td><td>" + s.thrs )
          .appendTo(tbody)
        } else {
          $("<tr><td colspan='8'>&nbsp;</td></tr>").appendTo(tbody)
        }
      }

      $('table .view-link').click(onClickViewLink)
      preparePagingBar(pageNo, totalCount)

    },
    function(error) {
      alert('데이터 조회 중 오류 발생!')
      throw error;
  }) //list()
} // displayList()

function preparePagingBar(pageNo, totalCount) {
  $('#page-no').text(pageNo)

  if (pageNo == 1) {
    $('#prev-btn').attr('disabled', true)
  } else {
    $('#prev-btn').attr('disabled', false)
  }

  var totalPage = parseInt(totalCount / 3) + (totalCount % 3 > 0 ? 1 : 0);

  if (pageNo == totalPage) {
    $('#next-btn').attr('disabled', true)
  } else {
    $('#next-btn').attr('disabled', false)
  }
} //preparePagingBar()

function onClickViewLink(event) {
  location.href = 'view.html?no=' + $(this).attr('data-no')
  event.preventDefault()
}
