"use strict"

window.$ = window.jQuery = require('jquery')
// mysql 모듈준비
const mysql = require('mysql')
// connection 객체 만들기
const connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})
// mysql db접속
connection.connect()

var tbody = $('#student-tbl > tbody')

listStudent(1)

$('#add-btn').click(function() {
  location.href = 'view.html'
})

$('#prev-btn').click(function() {
  var currPageNo = parseInt($('#page-no').text())
  listStudent(currPageNo - 1)
})

$('#next-btn').click(function() {
  // 현재 페이지번호를 알아내자
  var currPageNo = parseInt($('#page-no').text())
  listStudent(currPageNo + 1)
})
// 반복코드를 함수로 만들자.
function listStudent(pageNo) {
  connection.query(
    'select m.mno, m.name, m.tel, m.email, s.work \
    from stud s inner join memb m on s.sno=m.mno  \
    order by m.name asc \
    limit ' + (pageNo - 1) * 3 + ', 3',
    function(error, results) {
      if (error) {
        alert('데이터 조회 중 발생!')
        throw error;
      }

      // 기존에 있던 tr 태그 삭제
      tbody.html('');
      // 쿼리날려서 results에 들어있는 값을 출력
      // 데이터이름 바로 씀
      // 무조건 세번 반복
      for (var i = 0; i < 3; i++) {
        // results에 존재하는 값이면 넣고
        if (i < results.length) {
          let s = results[i]
          $("<tr>").html("<td>" + s.mno +
          "</td><td><a href='#' data-no='" + s.mno + "' class='view-link'>" + s.name +
          "</a></td><td>" + s.tel +
          "</td><td>" + s.email +
          "</td><td>" + (s.work == "Y" ? "재직중" : "실업") + "</td>")
          .appendTo(tbody)
        } else { // 존재하지않으면 빈 tr을 만들어 넣는다.
          $("<tr><td colspan='5'>&nbsp;</td></tr>").appendTo(tbody)
        }
      }

      $('table .view-link').click(onClickViewLink)

      preparePagingBar(pageNo)

      console.log('list 가져오는 거 처리끝!')
    }) // connection.query()

  console.log('listStudent() 호출 끝!!!')
}

function preparePagingBar(pageNo) {
  $('#page-no').text(pageNo)
  // 현재페이지가 1일 경우 비활성화. db값 가져오는 것과 관계없음
  if (pageNo == 1) {
    $('#prev-btn').attr('disabled', true)
  } else {
    $('#prev-btn').attr('disabled', false)
  }
  // 비동기인 것을 주의하자.
  connection.query(
    'select count(*) cnt from stud',
    function(error, results) {
      if (error) {
        alert('데이터 조회 중 발생!')
        throw error;
      }

      var totalCount = results[0].cnt; // 전체 레코드 수
      var totalPage = parseInt(totalCount / 3) + (totalCount % 3 > 0 ? 1 : 0);

      if (pageNo == totalPage) {
        $('#next-btn').attr('disabled', true)
      } else {
        $('#next-btn').attr('disabled', false)
      }

      console.log('count(*) 처리 끝!')
    }) //connection.query()
  console.log('preparePagingBar() 호출 끝!!!')
}

function onClickViewLink(event) {
  location.href = 'view.html?no=' + $(this).attr('data-no')
  event.preventDefault()
}
