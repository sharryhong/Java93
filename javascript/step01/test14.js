/* 주제: 상수 변수 - const II
- 상수 변수는 선언할 때 값을 지정해야 한다.
- 문법
const 변수명 = 값;
*/
"use static"

const name = "홍길동"; // 상수변수는 항상 선언과 동시에 값을 지정해야한다.
console.log(name);

const age; // Missing initializer in const declaration 실행 오류
age = 20;
console.log(age);
