"use strict"
window.$ = window.jQuery = require('jquery')

let xCol = 4, // 행의 갯수
    yRow = 4, // 열의 갯수
    numArray = [], // 숫자들 담을 배열
    nums = null, // 숫자버튼 엘리먼트
    blankEl = null, // 빈칸 엘리먼트
    blankX = 0,
    blankY = 0,
    canClickEl = [], // 클릭할 수 있는 엘리먼트
    puzzleTable = $('#puzzle-table');

makeNumArray()

// 배열에 숫자들 담는 함수
function makeNumArray() {
  var startNum = 1
  var totalNum = xCol * yRow
  for (let i = 0; i < xCol; i++) {
    numArray[i] = new Array()  // 2차원배열로 만들기위해
    for (let j = 0; j < yRow; j++) {
      numArray[i][j] = startNum++ // 숫자 넣기
      if (startNum - 1 == totalNum) {
        numArray[i][j] = '' // 마지막 숫자에 빈칸 넣기
      }
    }
  }
  displayNum()
}

// 숫자 화면 UI
function displayNum() {
  var html = ''
  for (let i = 0; i < xCol; i++) {
    html += '<tr>'
    for (let j = 0; j < yRow; j++) {
      if (numArray[i][j] == '') {
        html += '<td id="blank" class="btn" data-x="'+ j + '" data-y="' + i + '">' + numArray[i][j] + '</td>'
      } else {
        html += '<td class="btn num" data-x="'+ j + '" data-y="' + i + '">' + numArray[i][j] + '</td>'
      }
    }
    html += '</tr>'
  }
  puzzleTable.html(html)

  // 빈칸 엘리먼트의 위, 오른쪽, 아래, 왼쪽 엘리먼트만 클릭이 되도록하기
  blankEl = $('#blank')
  blankX = blankEl.attr("data-x")
  blankY = blankEl.attr("data-y")
  nums = $('.num')
  for (let el of nums) {
    if (el.getAttribute("data-x") == blankX && el.getAttribute("data-y") == blankY - 1) { // 위
      el.classList.add('can-click')
      canClickEl.push(el)
    }
    if (el.getAttribute("data-x") == blankX - 1 && el.getAttribute("data-y") == blankY) { // 왼쪽
      el.classList.add('can-click')
      canClickEl.push(el)
    }
  }

  canClickEl.push(blankEl[0]) // 빈칸도 추가해야 제대로 동작한다.
  for (let el of canClickEl) {
    el = $(el) // 일반 DOM 엘리먼트를 jQuery 엘리먼트로
    el.click(function() {
      var firstNum = $(this)
      var txt = parseInt(firstNum.text())
      blankEl.removeAttr('id').addClass('num can-click').html(txt)
      firstNum.removeClass('num can-click').text('').attr('id', 'blank')
      blankEl = firstNum
    })
  }
}


















//
