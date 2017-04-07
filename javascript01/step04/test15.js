/* 주제 : 함수 - 함수의 아규먼트를 받아 저장하는 내장 변수 "arguments"
*/

"use strict"

function f1(a, b) {
  console.log(arguments.length);
  console.log(arguments);
  console.log("----------------------------");
}

// JS는 파라미터의 개수에 상관없이 값을 넘길 수 있다.
f1()                 // undefined, undefined // 오류 아니다.
f1(10)               // 10, undefined        // 오류 아니다.
f1(10, 20)
f1(10, 20, 30)       // 10, 20               // 오류 아니다.
f1(10, 20, 30, 40)   // 10, 20               // 오류 아니다.

function f2(a, b) {
  console.log(arguments.length)
  console.log(arguments)
  console.log(a, b)
  console.log('================')
}

f2()
f2(10)
f2(10, 20)
f2(10, 20, 30)
f2(10, 20, 30, 40)

// "arguments" 응용하기
// 아큐먼트 개수를 고정시킬 수 없을 때 쓴다.
function sum() {
  var result = 0;
  for (var value of arguments) {
    result += value;
  }
  return result;
}

console.log(sum())
console.log(sum(10))
console.log(sum(10, 20))
console.log(sum(10, 20, 30, 40, 50))
