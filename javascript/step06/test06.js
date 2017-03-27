/* 주제: 모듈.
*/

"use strict"

// require(모듈 경로)
// => module.exports 객체를 리턴한다.
var m1 = require('./test06_m1.js')

//
console.log(m1.plus(10, 20))
console.log(m1.minus(10, 20))
console.log(m1.multiple(10, 20))
// 
// console.log(m1.divide(10, 20))
