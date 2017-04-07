/* 주제 : 함수 - 함수를 파라미터로 넘기기
*/

"use strict"

function plus(a, b) {
  return a + b;
}

function minus(a, b) {
  return a - b;
}

// 함수 (주소)를 받을 수 있다.
// plus()나 minus()함수처럼 다른 함수에 의해 거꾸로 호출되는 함수를
// "콜백(callback)" 함수라고 부른다.
// 콜백 함수의 주소를 저장하는 변수명은 보통 callback의 약자인 "cb"를 사용한다.
function caller(cb) { // 파라미터에 함수 메모리 주소를 받아,
  var value = cb(20, 30); // f변수를 함수처럼 쓸 수 있다.
  console.log(value);
}

// 함수 (주소)를 넘길 수 있다.
caller(plus);
caller(minus);
