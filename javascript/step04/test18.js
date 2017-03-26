/* 주제 : 함수 - 로컬(local) 변수와 스택(stack) 메모리
*/

"use strict"

var v1 = 100; // 글로벌(global) 변수

function f1() {
  var v1 = 200;
  console.log('f1() 1_: ', v1);
  f2(); // f2()함수가 다 실행되고나서야 다음라인이 실행된다. => "동기방식"
  console.log('f1() 5_: ', v1);
}

function f2() {
  var v1 = 300;
  console.log('f2() 2_: ', v1);
  f3();
  console.log('f2() 4_: ', v1);
}

function f3() {
  var v1 = 400;
  console.log('f3() 3_: ', v1);

}

f1();
