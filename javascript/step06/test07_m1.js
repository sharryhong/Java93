/* 주제:
*/

"use strict"

// require하면 exports객체가 리턴되므로 아래가 그대로 리턴된다. 
module.exports = {
  plus(a, b) {return a + b},
  minus(a, b) {return a - b},
  multiple(a, b) {return a * b},
  divide(a, b) {return a / b}
}
