"use strict"

let numbers = document.querySelectorAll(".number")
let numInput = document.querySelector("#numInput")
let plusBtn = document.querySelector("#plus")
let minusBtn = document.querySelector("#minus")
let multiplyBtn = document.querySelector("#multiply")
let divideBtn = document.querySelector("#divide")
let acBtn = document.querySelector("#acBtn")
let equalBtn = document.querySelector("#equal")
// 연산 버튼 클릭시 input에 새로 입력받기
let checkBtn = true
// preNum과 nowNum 구분
let checkPreNum = false
// 숫자버튼들 클릭시 inputNum함수 호출
for (let i = 0; i < numbers.length; i++) {
  // console.log(numbers[i])
  numbers[i].addEventListener('click', inputNum)
}
// 숫자버튼의 콘텐츠내용을 input태그(id="numInput")에 뿌리기
function inputNum() {
  if(!checkBtn)
    clearNum()
  var num = this.innerHTML
  numInput.value += num
  checkBtn = true
}
// 입력창 콘텐츠 내용 삭제
function clearNum() {
  numInput.value = ""
}

// 계산기 객체
let cal = {
  result: 0,
  preNum: 0,
  nowNum: 0,
  plus: function() {
    cal.realCal('+');
  },
  minus: function() {
    cal.realCal('-');
  },
  multiply: function() {
    cal.realCal('*');
  },
  divide: function() {
    cal.realCal('/');
  },
  // 공통 메소드
  realCal: function(op) {
    checkBtn = false
    if(!checkPreNum) {
      cal.preNum = Number(numInput.value)
      console.log(cal.preNum)
      // clearNum()
      checkPreNum = true
    } else {
      cal.nowNum = Number(numInput.value)
      console.log(cal.nowNum)
      switch (op) {
        case '+':
          cal.result = cal.preNum + cal.nowNum
          break;
        case '-':
          cal.result = cal.preNum - cal.nowNum
          break;
        case '*':
          cal.result = cal.preNum * cal.nowNum
          break;
        case '/':
          cal.result = cal.preNum / cal.nowNum
          break;
      }
      clearNum()
      cal.preNum = cal.result
      numInput.value = cal.result
      checkBtn = false
    }
    // return cal.result
  }
}

plusBtn.addEventListener('click', cal.plus)
minusBtn.addEventListener('click', cal.minus)
multiplyBtn.addEventListener('click', cal.multiply)
divideBtn.addEventListener('click', cal.divide)
acBtn.addEventListener('click', function() {
  numInput.value = ""
  cal.result, cal.preNum, cal.nowNum = 0
  checkPreNum = false
})
// equalBtn.addEventListener('click', cal.realCal)
