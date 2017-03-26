/* 주제: 객체 - read only 프로퍼티 만들기
*/

"use strict"

var obj = {}
obj.result = 10 // read/write 가능

// read only 프로퍼티 만들기
/* 문법
Object.defineProperty(객체, 프로퍼티명, 옵션)
*/
//
Object.defineProperty(obj, 'result2', {
  value: '100'
})

console.log(obj); // result2는 안보인다.
console.log(obj.result); // 10
console.log(obj.result2); // 100
console.log('---------------------------');

obj.result = 20
console.log(obj.result); // 20

obj.result2 = 200 // Error!
console.log(obj.result2);
