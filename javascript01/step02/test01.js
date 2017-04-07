/* 주제: 연산자 - 산술 연산자
- +, -, *, /, %, **
*/
"use static"

var a = 7;
var b = 2;

console.log(a + b); // 9
console.log(a - b); // 5
console.log(a * b); // 14
console.log(a / b); // 3.5
console.log(a % b); // 1
console.log(b ** 3); // 거듭제곱
                    // node v7이상 지원. 아직 크로스브라우징 안됨

console.log(10 / 0); // Infinity(무한)
console.log(-10 / 0); // -Infinity
