/* 주제: 연산자 - 암시적 형변환(implicit type casting(conversion))
- 피연산자의 타입이 다르면 연산을 수행할 수 없다.
  이런 경우 자바스크립트 엔진은 자바스크립트 명세서에서 정한 규칙에 따라
  두 개의 값 중에서 한 개의 값을 다른 한 개의 값과 동일한 타입으로 자동변환한다.
  내부적으로 자동 변환하는 것을 "암시적 형변환"이라 부른다.
*/
"use strict"

/* 원래.. 아래처럼 다른 타입끼리 비교하는 것은 코딩에 문제가 있는 것이다.
   예측하지 못한 상황이 생길 수 있다.
   따라서 === 만 쓰자. 암시적 형변환 자체를 하지 않는다.
*/

/*
규칙1)
- 피연산자 중에 number나 boolean 값이 있으면,
- 나머지 하나를 number로 바꾼 다음에 연산을 수행한다.
*/
console.log("7" == 7); // true // "7"이 number 7로 바뀐다. 7 == 7
console.log("7" == 8); // false // "7"이 number 7로 바뀐다. 7 == 8

console.log("0" == false); // true // 0 == 0
console.log("1" == true); // true // 1 == 1
console.log("true" == true); // false // NaN == 1
console.log("hello" == true); // false // NaN == 1
console.log("" == false); // true // 0 == 0

console.log("false == NaN", false == NaN); // false // 0 == NaN

/*
규칙2)
- boolean과 number를 연산할 때 boolean을 number로 변환한다.
*/
console.log("false == 0", false == 0); // true // 0 == 0
console.log("false == []", false == []); // true // 0 == 0
console.log("-------------");

console.log(true == 7); // false // true가 1로 바뀐다. 1 == 7
console.log(false == 0); // true // false가 0으로 바뀐다. 0 == 0

/*
규칙3)
- null, undefined는 그 의미대로 비교한다.
  즉 암시적 형변환을 하지 않는다.
- null의 의미는 변수가 비어 있다.
- undefined의 의미는 변수가 없다.
*/
console.log("false == null", false == null); // false // 0 == null
console.log("false == undefined", false == undefined); // false // 0 == undefined
console.log("0" == null); // false
console.log("0" == undefined); // false
