/* 주제: 객체 - 클로저 변수를 사용하여 result변수를 감추는 효과. 
*/

"use strict"

function Calculator() {
}
let result = 0
Calculator.prototype.plus = function(value) {
  // 함수 밖의 변수가 let변수 이므로 메모리에 따로 갖고 있다. (클로저에서 배운 내용)
  result += value
}
Calculator.prototype.minus = function(value) {
  //
  result -= value
}
// 같은 메모리 상에 있는 result를 리턴하는 함수를 만든다.
Calculator.prototype.getResult = function(value) {
  return result
}

var calc1 = new Calculator()

calc1.plus(100)
calc1.minus(20)
calc1.plus(10)
calc1.result = 10000 // 못바꾸지롱!
console.log(calc1.result); // undefined.
console.log(calc1.getResult()) // 90.

// => 나중에 모듈로 감쌀 것이다.
