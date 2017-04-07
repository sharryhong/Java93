/* 주제 : 함수 - 글로벌(global) 변수와 로컬(local) 변수
*/

"use strict"

var v1 = 100;

function f1() {
  console.log('f1() : ', v1);
  v1 = 200;
}

console.log('f1()호출 전 : ', v1);
f1(); // 여기서 실행됨(호출)
console.log('f1()호출 후 : ', v1);
