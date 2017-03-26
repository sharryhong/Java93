/* 주제: 흐름 제어문 - 조건문 else의 소속
- else 는 바로 전에 나온 if 문에 묶인다.
*/

"use strict"

var age;

age = 50;
if (age > 19)
  if (age >= 65)
    console.log('노인');
else // 착각하지말자. else문은 바로 전에 나온 if문에 묶인다.
  console.log('미성년');
console.log('--------------');

//
age = 50;
if (age > 19) {
  if (age >= 65)
    console.log('노인');
}
else // 이제 생각한 바 대로 되었다.
  console.log('미성년');
console.log('--------------');
