/* 주제: 객체 - 일반 함수와 인스턴스 함수
*/

"use strict"

function Calculator() {
  this.result = 0 // 인스턴스 변수 (인스턴스가 필요로하는 변수)
}

// prototype의 용도 : 인스턴스를 다루는 함수를 두는 것
Calculator.prototype.plus = function(value) {this.result += value} // 인스턴스 함수
Calculator.prototype.plus2 = function(a, b) {return a + b} // 인스턴스 함수

var c1 = new Calculator()
var c2 = new Calculator()

c1.plus(100) // c1이 가리키는 인스턴스의 result변수 + 100
var r1 = c1.plus2(100, 200) //
console.log(c1.result)
console.log(r1)

c2.plus(200)
var r2 = c2.plus2(1000, 2000)
console.log(c2.result)
console.log(r2)


// 여기서 탐탁치 않은 부분은??
/* c1.plus(100), c2.plus(200) 의 경우 this에 각 객체의 주소가 있다.
   -> 즉, this를 사용해야할 때만 인스턴스 함수로 만들면 된다. */
// plus2()에서는 인스턴스를 안쓰는데(this를 안쓰는데) prototype에 저장시켜놓았다. => 잘못저장한것!


// 아래처럼 일반객체에 함수를 담아도 되겠지만
var obj = {}
obj.plus2 = function(a, b) {return a + b}
// 함수도 객체다! 라는 개념을 이용하면 더 좋은 코드로 만들 수 있다.
// Calculator()함수와 관련된 기능을 저장하기 위해
Calculator.plus2 = function(a, b) {return a + b}
// 유지보수를 위해!! 이렇게 하면 더 좋것지유~
// 호출
var r3 = Calculator.plus2(100, 200)
console.log(r3)
