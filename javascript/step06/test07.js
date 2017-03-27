/* 주제: 모듈. exports를 사용자가 다른 객체로 대체하기
*/

"use strict"

// require(모듈 경로)
// => module.exports 객체를 리턴한다.
var m1 = require('./test07_m1.js')

console.log(m1.plus(10, 20))
console.log(m1.minus(10, 20))
console.log(m1.multiple(10, 20))
console.log(m1.divide(10, 20))

// step05/test21.js에서 배운 방법
// 필요한 것만 불러올 때. 아주 편한 방법!
var {plus, minus} = require('./test07_m1.js')

console.log(plus(10, 20));
console.log(minus(10, 20));
