/* 주제: 객체 - prototype
장점: 함수를 중복해서 생성하지 않는다.
*/

"use strict"

function Calculator() {
  this.result = 0 // 객체마다 다르게 다루므로 얘는 넵두고~!
}

// 함수들은 각 객체들이 공동으로 사용할 수 있다. 이것을 prototype으로.. 객체주소를 저장한다.
Calculator.prototype.plus = function(value) {this.result += value}
Calculator.prototype.minus = function(value) {this.result -= value}
Calculator.prototype.multiple = function(value) {this.result *= value}
Calculator.prototype.divide = function(value) {this.result /= value}

// 객체는 여전히 다 따로 생기는 것이다.
var c1 = new Calculator()
var c2 = new Calculator()
var c3 = new Calculator()

c1.plus(10)
c2.minus(20)
c3.plus(30)
// c1, c2, c3 객체 생성했을 때 : 각기 Calculator {result: 0}만 담겨있다.
// 1_ c1에서 plus()함수를 찾는다. => 없다.
// 2_ 객체를 초기화시킨 생성자함수를 찾아간다. prototype에 해당 함수가 있는지 찾아본다. => 있다!
// this에는 함수를 호출할때 객체의 주소가 들어가있으므로 제대로 찾아갈 수 있다.
// 따라서 this가 없으면 객체를 구분할 수 없다.

console.log(c1.result);
console.log(c2.result);
console.log(c3.result);

// 아래의 this는 prototype을 가리킨다. 즉, 이렇게 쓰지않는다. 이럴라고 prototype쓰는게 아니야~
// Calculator.prototype.plus(10);
