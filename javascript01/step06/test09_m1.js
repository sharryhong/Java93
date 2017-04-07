/* 주제: exports 객체를 함수 객체로 대체하기 II
*/

"use strict"

// 기존에 module에 들어있던 exports 객체를 우리가 만든 객체로 대체한다.
module.exports = function() { // 객체를 리턴하는 함수를 리턴
  return {
    result: 0,
    plus(value) {this.result += value},
    minus(value) {this.result -= value},
    multiple(value) {this.result *= value},
    divide(value) {this.result /= value}
  }
}
