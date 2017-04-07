/* 주제 : 함수 - arrow 함수를 리턴 받기
*/

"use strict"

function calculator(op) {
  switch (op) {
    case "+":
      // 익명함수를 더 축약한 arrow function을 정의한 후 그 주소를 리턴한다.
      return (a, b) => a + b
    case "-":
      return (a, b) => a - b
  }
}

var f = calculator("+"); // 더하기 함수(의 주소)를 줘봐~
var value = f(10, 20);
console.log(value);

f = calculator("-");
value = f(10, 20);
console.log(value);
