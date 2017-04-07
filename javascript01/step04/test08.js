/* 주제 : 함수 - arrow function 2
*/

"use strict"

// arrow함수에서는 마지막 문장의 실행결과가 리턴 값이다.
var f1 = () => "hello";

var value = f1(); // return값 저장
console.log(value);

// 만약 마지막 문장의 실행 결과 값이 없을 경우, 값을 리턴하지 않는다.
var f2 = () => console.log("난 리턴값이 없어요.");
var value = f2();
console.log(value); // undefined

var f3 = () => {
  console.log("------------------------");
  console.log("f3() .. 호출됨");
  console.log("Arrow 함수임");
  return "Hello!!"; // 블록 안에서 값을 리턴할 땐 반드시 return 명령을 사용해야한다.
}
value = f3();
console.log(value);

// 파라미터를 받는 arrow function
// var f4 = (a, b) => a + b; // 괄호 생략 불가
/*
var f4 = function(a, b) {
  return a + b;
}
*/
value = f4(10, 20);
console.log(value);
