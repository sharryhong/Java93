/* 주제: 모듈. exports를 함수 객체로 대체하기 2
*/

"use strict"

module.exports = function() { // 객체를 리턴하는 함수를 리턴
  return {
    result: 0,
    plus(value) {this.result += value},
    minus(value) {this.result -= value},
    multiple(value) {this.result *= value},
    divide(value) {this.result /= value}
  }
}
