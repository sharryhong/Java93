/* 주제: 기타 - eval() 함수
- nodeJs와 웹브라우저 실행이 약간다르다.
*/

"use strict"

//
var obj = {
  name: '홍길동',
  age: 20
}
console.log(obj)

//
var str = "var v1 = 20, v2 = 30; console.log(v1 + v2)"

// str에있는 js코드를 실행하라.
eval(str)

var obj2 = eval("var x1 = 100, x2 = 200;")
console.log(obj2)
