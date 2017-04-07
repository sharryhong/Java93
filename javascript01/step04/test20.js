/* 주제 : 함수 - 함수 호출 동기 방식과 비동기 방식 2
*/

"use strict"

// 모듈 가져오기
var prompt = require('prompt');

// Start the prompt
prompt.start();

/*
var arr = ['a', 'b'];

function f1(error, result) {
  console.log(result.a, result.b)
}

// prompt객체안에 있는 get이라는 함수를 호출한다. 받는값, 호출될 함수(콜백 함수)
prompt.get(arr, f1);
*/

// ['a', 'b'] 한번만 쓰고, 콜백함수도 한번만 쓴다면 이렇게 코딩하는게 좋다.
// 소스분석, 유지보수상에서도 좋다.

// 비동기 호출 방식의 예
//
prompt.get(['a', 'b'], function(error, result) {
  console.log("입력 값 출력 --------------------")
  console.log(result.a, result.b)
});

console.log("동기방식이면 이거 출력안될텐데?? 이건 된다!");
