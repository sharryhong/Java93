"use strict"

let numbers = document.querySelectorAll(".number")
let opText = document.querySelectorAll(".op")
let numInput = document.querySelector("#numInput")
let plusBtn = document.querySelector("#plus")
let minusBtn = document.querySelector("#minus")
let multiplyBtn = document.querySelector("#multiply")
let divideBtn = document.querySelector("#divide")
let acBtn = document.querySelector("#acBtn")
let equalBtn = document.querySelector("#equal")
// 연산 버튼 클릭시 input에 새로 입력받기
let checkBtn = false
// preNum과 nextNum 구분
let checkPreNum = false
// 숫자버튼 클릭시 inputNum함수 호출
for (let i = 0; i < numbers.length; i++) {
  numbers[i].addEventListener('click', inputNum)
}
// 해당 콘텐츠내용을 input box에 뿌리기
function inputNum() {
  var inputText = this.innerHTML
  numInput.value += inputText
  checkBtn = false
}
// 입력창 콘텐츠 내용 삭제
function clearNum() {
    numInput.value = ""
    console.log("clear")
}

// 계산기 객체
let cal = {
  result: 0,
  preNum: 0,
  nextNum: 0,
  preOp: null,
  op: null,
  calculator: function() {
    checkBtn = true
    cal.op = this.innerHTML
    if (!checkPreNum) {
      cal.preNum = Number(numInput.value)
      console.log(cal.preNum)
      checkPreNum = true
      clearNum()
    } else {
      cal.nextNum = Number(numInput.value)
      console.log(cal.nextNum)
      checkPreNum = false
      clearNum()
      cal.resultFn(cal.preOp)
    }
    cal.preOp = cal.op
  },
  resultFn: function(op) {
    switch (op) {
    case '+':
    cal.result = cal.preNum + cal.nextNum
    console.log("result"+cal.result)
    break;
    case '-':
    cal.result = cal.preNum - cal.nextNum
    console.log("result"+cal.result)
    break;
    case '*':
    cal.result = cal.preNum * cal.nextNum
    console.log("result"+cal.result)
    break;
    case '/':
    cal.result = cal.preNum / cal.nextNum
    console.log("result"+cal.result)
    break;
    }
    numInput.value = cal.result
  }
}

// 연산자버튼 클릭시
for (let i = 0; i < opText.length; i++) {
  opText[i].addEventListener('click', cal.calculator)
}
