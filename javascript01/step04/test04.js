/* 주제: 함수 - 함수 호이스팅(hoisting) II
- 변수 선언에 초기화 문장이 있을 때,
  변수 선언만 호이스팅 된다.
*/

"use strict"

console.log(name); // undefined. var name부분만 hoisting되기 때문이다.

var name = "홍길동";

console.log(name);
