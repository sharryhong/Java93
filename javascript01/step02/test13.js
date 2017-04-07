/* 주제: 연산자 - 연산자 우선 순위
- 한 식(expression) 안에 여러 개의 연산자가 사용될 때,
  연산자 우선순위에 따라 실행하는 순서가 결정된다.
- 우선순위
1: ()
2: x++, x--
3: !x(논리값 not), ~x(비트값 not), ++x, --x
4: **
5: *, /, %
6: +, -
*/
"use strict"

var r;
r = 10 + 2 * 3;
console.log(r);

r = (10 + 2) * 3;
console.log(r);

r = 10 - 3 + 7;
console.log(r);

r = 10 / 2 * 3;
console.log(r);

var a = 10;
r = a++ + a++ - a++; // 10 + 11 - 12 = 9 // a = 13
console.log(r, a);
