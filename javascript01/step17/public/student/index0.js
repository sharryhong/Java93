var pageNoTag = $('#page-no'),
    tbody = $('#student-tbl > tbody'),
    prevBtn = $('#prev-btn'),
    nextBtn = $('#next-btn');  // 세미콜론 안해도 되지만 끝임을 강조하기 위해 적자
var pageSize = 3
var currPageNo = parseInt(pageNoTag.text())
displayList(1)

function displayList(pageNo) {
  // 서버에서 학생 목록 데이터를 받아온다.
  // 비동기 방식
  // {}는 전달할 데이터
  // function(result){} : 서버에서 정상적으로 응답오면 실행
  $.getJSON('list.json', {'pageNo': pageNo, 'pageSize': pageSize}, function(result) {
    var list = result.list
    var totalCount = result.totalCount
    var lastPageNo = parseInt(totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0)
    tbody.text('') // 다시 실행될때 기존것 삭제
    for (var s of list) {
      //부모.append(자식)
      $('<tr>').append($('<td>').text(s.mno))
      .append($('<td>').append(
        $('<a>').attr('href', 'view.html?no=' + s.mno)
                .text(s.name == '' ? '(이름 없음)' : s.name)))
      .append($('<td>').text(s.tel))
      .append($('<td>').text(s.email))
      .append($('<td>').text(s.work))
      .appendTo(tbody)
    }
    currPageNo = pageNo // currPageNo는 항상 현재 페이지 값을 가지고 있다.
    pageNoTag.text(currPageNo) // data를 출력하는 UI객체

    // 서버에서 리스트를 받아와서 출력할 때 버튼을 어떻게 처리할지 결정
    if (currPageNo == 1) {
      prevBtn.prop('disabled', true)
    } else {
      prevBtn.prop('disabled', false)
    }

    if (currPageNo == lastPageNo) {
      nextBtn.prop('disabled', true)
    } else {
      nextBtn.prop('disabled', false)
    }

  }) // getJSON()
} // displayList()

prevBtn.click(function() {
  displayList(currPageNo - 1)
})

nextBtn.click(function() {
  displayList(currPageNo + 1)
})







//
