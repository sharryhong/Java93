/* 주제: 스태틱 타입 바인딩과 다이나믹 타입 바인딩
스태틱 타입 바인딩(static type binding)
  - 변수(메모리)의 용도를 고정하는 방식
  - 변수를 만들 때 선언한 용도대로만 값을 넣어야 한다.
  - 예) C, C++, C#, Java 등
다이나믹 타입 바인딩(dynamic type binding)
  - 변수(메모리)의 용도가 가변적이다.
  - 값을 넣는 순간 그 용도로 자동 설정된다.
  - 예) JavaScript 등 스크립트 류는 보통 동적 타입 바인딩 방식이다.
*/

"use strict"
var name;
console.log(typeof name); // undefined. 용도가 지정되지 않았다.

name = "홍길동";
console.log(typeof name); // string.

name = '임꺽정';
console.log("name :",typeof name);

name = 20;
console.log(typeof name); // number

name = 3.14;
console.log(typeof name); // number

name = true;
console.log(typeof name); // boolean

name = new Object(); // object. 객체
console.log(typeof name);

name = [];
console.log(typeof name); // object. 배열

name = function(){};
console.log(typeof name); // function. 함수

name = null;
console.log(typeof name); // object

name = undefined;
console.log(typeof name); // undefined. 초기화

name = NaN; // Not a number
console.log(typeof name); // number
