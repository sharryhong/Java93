/* 주제: 객체 - 일반 객체와 함수 객체 응용
*/

"use strict"

// 함수 객체 응용편
// 1) 역할
function Calculator() {
  this.result = 0
}

// 2) 인스턴스 함수 추가
//
Calculator.prototype.plus = function(value) {this.result += value}
Calculator.prototype.minus = function(value) {this.result -= value}

// 3) 일반 함수 추가
//
Calculator.plus = function(a, b) {return a + b}
Calculator.minus = function(a, b) {return a - b}

//
var calc1 = new Calculator() // new로 만든 빈 객체(calc1)에 함수를 호출한다(this.result = 0 실행)
                            // this에 calc1 주소가 담겨있다.
//
calc1.plus(100) // 1_calc1에 있나 찾는다. 없으면
                // 2_clac1이라는 인스턴스주소를 줬기 때문에 Calculator() 함수 객체에 가서 prototype에 있는지 찾는다.
calc1.minus(20) //
calc1.plus(10)  //
console.log(calc1.result);

//
var r1 = Calculator.plus(100, 200)
var r2 = Calculator.minus(100, 200)
console.log(r1, r2);
