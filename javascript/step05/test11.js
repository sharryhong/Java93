/* 주제: 객체 - 생성자 함수의 이름 2
*/

"use strict"

function Calculator() {
  this.result = 0
  this.plus = function(value) {this.result += value}
  this.minus = function(value) {this.result -= value}
  this.multiple = function(value) {this.result *= value}
  this.divide = function(value) {this.result /= value}
}

var calc = new Calculator()
console.log(calc)

calc.plus(10)
calc.plus(20)
calc.multiple(3)
calc.minus(7)
calc.divide(2)
console.log(calc.result)
