/* 주제 : 함수 - 파라미터로 arrow function(의 주소) 넘기기
*/

"use strict"

// 함수 (주소)를 받을 수 있다.
function caller(f) { // 파라미터에 함수 메모리 주소를 받아,
  var value = f(20, 30); // f변수를 함수처럼 쓸 수 있다.
  console.log(value);
}

// 함수 (주소)를 넘길 수 있다.
// 방법 1
function plus(a, b) { // 함수의 이름이 (함수의 주소를 저장한) 변수이다.
  return a + b;
}
caller(plus);

// 방법 2
var plus2 = function(a, b) {
  return a + b;
}
caller(plus2);

// 방법 3
// 만약 이 함수를 한번만 쓴다면 이렇게도 할 수 있다.
// 1) plus3() 함수를 정의한 후 그 자리에 그 함수의 주소를 놓는다.
// 2) 그리고 caller() 호출하여 그 자리에 놓은 주소를 넘긴다.
// 3) caller를 호출한다.
caller(function plus3(a, b) {
  return a + b;
});

// 방법 4
// 파라미터로 넘기는 함수는 굳이 이름을 가질 필요가 없다.
// 보통 익명함수로 정의한다.
caller(function(a, b) {
  return a + b;
});

// 방법 5
// ECMAScript 2015버전부터는 익명함수를 쉽게 정의할 수 있는 문법을 제공한다.
// 그 문법이 arrow function이다.
caller((a, b) => a + b);
