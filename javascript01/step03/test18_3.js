/* 주제: 예외처리(throw)
*/

"use strict"

// throw 명령어 적용
function divide(a, b) {
  if (b == 0) // 0으로 나누려 한다면
    // 오류 정보를 담은 객체를 던질 수 있다.
    throw {errorCode: 400, message: '0으로 나눌 수 없다.'}
  return a / b
}

// throw 명령어로 던진 예외 정보를 처리하기 전
// => throw를 통해 예외를 받게되면 JavaScript Engine은 즉시 실행을 멈춘다.
//    즉, 아래 console.log(~) 실행되지 않는다.
// 24시간 실행해야하는 시스템의 경우, 예외상황이 발생했다고해서 멈춘다면, 고객서비스를 수행하지 못하는 치명적인 문제 발생
// => 해결책? 예외 상황 처리 문법 필요 => test18_4.js
var result = divide(1212121212, 0)
console.log('--------------------------------');
console.log(result);
