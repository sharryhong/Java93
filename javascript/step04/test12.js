/* 주제 : 함수 - 함수를 리턴 받기
*/

"use strict"

function calculator(op) {
  switch (op) {
    case "+":
      // 익명함수를 정의한 후, 그 익명함수의 주소를 리턴한다.
      return function(a, b) { return a + b; };
    case "-":
      return function(a, b) {
        return a - b;
      };
  }
}

var f = calculator("+"); // 더하기 함수(의 주소)를 줘봐~
var value = f(10, 20);
console.log(value);

f = calculator("-");
value = f(10, 20);
console.log(value);

// 실무에서는 리턴받은 함수(의 주소)를 바로 사용하는 경우가 많다.
value = calculator("-")(30, 20); // 함수 바로 호출
console.log(value);

// 리턴 값을 바로 출력할 수 있다.
console.log(calculator("+")(100, 50));
