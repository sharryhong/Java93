"use strict"
window.$ = window.jQuery = require('jquery')

let xCol = 4, // 행의 갯수
    yRow = 4, // 열의 갯수
    numArray = [], // 숫자들 담을 배열
    blankEl = null, // 빈칸 엘리먼트
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
        html += '<td id="blank">' + numArray[i][j] + '</td>'
      } else {
        html += '<td class="num">' + numArray[i][j] + '</td>'
      }
    }
    html += '</tr>'
    blankEl = $('#blank')
    console.log(blankEl);
  }
  puzzleTable.html(html)
}
