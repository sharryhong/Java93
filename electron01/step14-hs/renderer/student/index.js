/* MVC패턴의 Control담당 */
"use strict"
window.$ = window.jQuery = require('jquery')
/* 이렇게 한 것을 아래에서 한줄로 적어준 것
// electron 관리자 객체 얻기
var electron = require('electron')
// main 프로세스에 접근하기
var remote = electron.remote
// main 프로세스의 global변수에서 값 꺼내기
var studentService = remote.getGlobal('studentService')
*/

/* electron에서 main.js(메인 프로세스). 크롬 브라우저 영역(렌더러 프로세스)이 있다.
  크롬브라우저위에서 html, js, css파일들이 돌아가고, main.js에 global.studentService가 있다.
  둘이 연결해줘야 하는데, 이 것을 remote가 해준다. (Doc참고)
*/
var studentService = require('electron').remote.getGlobal('studentService')

var tbody = $('#student-tbl > tbody')

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
  studentService.list(
    pageNo,
    // service에서 처리한 값을 받는다.
    // results엔 selectList에서 처리한 데이터객체, totalCount엔 result[0].cnt인 row갯수가 들어온다. 
    function(results, totalCount) {
      tbody.html('');
      for (var i = 0; i < 3; i++) {
        if (i < results.length) {
          let s = results[i]
          $("<tr>").html("<td>" + s.mno +
          "</td><td><a href='#' data-no='" + s.mno + "' class='view-link'>" + s.name +
          "</a></td><td>" + s.tel +
          "</td><td>" + s.email +
          "</td><td>" + (s.work == "Y" ? "재직중" : "실업") + "</td>")
          .appendTo(tbody)
        } else {
          $("<tr><td colspan='5'>&nbsp;</td></tr>").appendTo(tbody)
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
