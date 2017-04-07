/* 주제: 흐름 제어문 - 조건문 if ~ else if ~ else if ~ else
- 문법
if (식)   <-- 식의 결과가 참이면 '명령문1'이 실행되고, 거짓이면 else 가 실행된다.
  명령문1;
else
  if (식) <-- 식의 결과가 참이면 '명령문2'가 실행되고, 거짓이면 else 가 실행된다.
    명령문2
  else
    명령문3
*/

"use strict"

var age;

age = 11;
if (age < 8)
  console.log("유아")
else { // <-- age >= 8
  if (age >= 8 && age < 14)
    console.log('어린이')
  else // <-- age >= 14
    console.log('청소년 이상')
}
console.log('-------------------');

// if ~ else ~는 한 그룹으로 취급한다.
age = 19;
if (age < 8)
  console.log("유아")
else  // if ~ else는 한문장! 그래서 블록 생략 가능
  if (age >= 8 && age < 14)
    console.log('어린이')
  else
    console.log('청소년 이상')
console.log('-------------------');

//
age = 99;
if (age < 8)
  console.log("유아")
else // <-- age >= 8, if ~ else ~ 는 한 문장이기 때문에 블록을 생략해도 된다.
  if (age >= 8 && age < 14)
    console.log('어린이')
  else
    if (age >= 14 && age < 20)
      console.log('청소년')
    else
      if (age >= 20 && age < 65)
        console.log('성인')
      else
        console.log('노인')
console.log('-------------------');

// 실무
// 원래는 위가 맞다. 이건 보기좋게만 한것이다.
// 즉, 주의!!! if ~ else if ~ else if ~ else라는 문법은 없다!
// 그냥 if ~ else 코드를 정돈한 것이다.
age = 99;
if (age < 8)
  console.log("유아")
else if (age >= 8 && age < 14)
  console.log('어린이')
else if (age >= 14 && age < 20)
  console.log('청소년')
else if (age >= 20 && age < 65)
  console.log('성인')
else
  console.log('노인')
console.log('-------------------');
