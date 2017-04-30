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
    console.log(result)
    var totalCount = result.totalCount
    var lastPageNo = parseInt(totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0)

    // 템플릿을 실행하는 함수 리턴
    var templateFn = Handlebars.compile($('#tbody-template').text())
    var generatedHTML = templateFn(result) // 템플릿 함수에 데이터를 넣고 html을 생성한다.
    // template(result) : html 리턴
    tbody.text('') // tbody의 기존 tr들을 지우고
    tbody.html(generatedHTML) // 새 tr 태그들로 설정한다.
    // 지우자마자 생성해야 화면 깜박임이 덜하다.

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
