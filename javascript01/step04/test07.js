/* 주제 : 함수 - arrow function
*/

"use strict"

// 익명함수 정의
var f1 = function() {
  console.log('익명함수...');
}
f1();

// arrow 함수 정의
// ECMAScript 2015 버전에서 추가된 문법
var f2 = () => {console.log('Arrow function')}
f2();

// 한문장만 있으면 중괄호 {} 생략가능
// 파라미터가 없을 때는 () 생략불가
var f3 = () => console.log('이렇게 한 문장으로 가능해요')
f3();
