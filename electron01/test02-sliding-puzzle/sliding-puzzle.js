"use strict"
window.$ = window.jQuery = require('jquery')

let xCol = 4,        // 행의 갯수
    yRow = 4,        // 열의 갯수
    numArray = [],   // 숫자들 담을 배열
    btns = null,     // 모든 엘리먼트
    blankEl = null,  // 빈칸 엘리먼트
    blankX = 0,      // 빈칸 엘리먼트의 행 값
    blankY = 0,      // 빈칸 엘리먼트의 열 값
    canClickEl = null, // 클릭할 수 있는 엘리먼트
    puzzleTable = $('#puzzle-table');

makeNumArray()

// 배열에 숫자들 담기
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

  canClick()

}

// 빈칸 엘리먼트의 위, 오른쪽, 아래, 왼쪽 엘리먼트만 클릭이 되도록하기
function canClick() {
  blankEl = $('#blank')
  blankX = parseInt(blankEl.attr("data-x"))
  blankY = parseInt(blankEl.attr("data-y"))
  btns = $('.btn')
  for (let el of btns) {
    el = $(el)
    if (el.attr("data-x") == blankX && el.attr("data-y") == blankY - 1) { // 위
      el.addClass('can-click')
    }
    else if (el.attr("data-x") == blankX - 1 && el.attr("data-y") == blankY) { // 왼쪽
      el.addClass('can-click')
    }
    else if (el.attr("data-x") == blankX + 1 && el.attr("data-y") == blankY) { // 오른쪽
      el.addClass('can-click')
    }
    else if (el.attr("data-x") == blankX && el.attr("data-y") == blankY + 1) { // 아래
      el.addClass('can-click')
    } else {
      el.removeClass('can-click')
    }
  }
  canClickEl = null
  canClickEl = $('.can-click')
  // class="can-click" 인 녀석들만 클릭되게 하기
  canClickEl.click(function() {
    var thisEl = $(this)
    // 자꾸 기존 class="can-click" 이었던 놈들도 클릭이 되어 조건문을 두었다.
    // canClickEl.click()이 메모리에 남아있는 것같다. clear할 수 있는 방법은? 
    if ( (thisEl.attr("data-x") == blankX && thisEl.attr("data-y") == blankY - 1) ||
          (thisEl.attr("data-x") == blankX - 1 && thisEl.attr("data-y") == blankY) ||
          (thisEl.attr("data-x") == blankX + 1 && thisEl.attr("data-y") == blankY) ||
          (thisEl.attr("data-x") == blankX && thisEl.attr("data-y") == blankY + 1) ) {
      var txt = parseInt(thisEl.text())
      blankEl.removeAttr('id').addClass('num can-click').html(txt)
      thisEl.removeClass('num can-click').text('').attr('id', 'blank')
      blankEl = thisEl
      canClick()
    }
  })
}




















//
