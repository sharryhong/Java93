/* 주제: 연산자 - 콤마 연산자
- 명령문을 연속해서 작성할 때 사용
- 문법
식, 식, 식;
*/
"use strict"

var a, b = 20, c;
console.log(a, b, c); // undefined 20 undefined

var r;
r = 100 * 2, 5 / 3, 4 + 7; // 콤마는 왼 -> 오른쪽으로 순차적으로 실행. 100 * 2가 r로 저장됨
console.log(r); // 200.

function f() {
  return 5, 7, 8; // 콤마는 왼 -> 오른쪽으로 실행. 따라서 마지막 값이 출력된다.
}

console.log(f());
