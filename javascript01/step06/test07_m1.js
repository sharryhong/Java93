/* 주제: exports 객체를 다른 객체로 대체하기
*/

"use strict"

// require하면 exports객체가 리턴되므로 아래가 그대로 리턴된다.
// 기존에 module에 들어있던 exports 객체를 우리가 만든 객체로 대체한다.
module.exports = {
  plus(a, b) {return a + b},
  minus(a, b) {return a - b},
  multiple(a, b) {return a * b},
  divide(a, b) {return a / b}
}
