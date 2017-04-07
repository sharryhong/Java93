/* 주제: 객체 - 변수 선언 시 값을 초기화시키는 다양한 방법
- 할당 연산자(=)를 사용하여 한 번에 여러 개의 배열 항목을 받을 수 있다.
- 문법
  var [변수1, 변수2, 변수3, ...] = 배열
  var {프로퍼티명1, 프로퍼티명2, ...} = 객체

*/

"use strict"

// 1) 각 변수 선언 마다 값 초기화시키기
var a = 10
var b = 20
var c = 30
console.log(a, b, c)

// 2) 한 번에 여러 개의 변수를 선언하고 초기화시키기
var i = 10, j = 20, k = 30
console.log(i, j, k)

// 3) 배열의 값을 한 번에 여러 변수에 할당하는 방법
var [x, y, z] = [10, 20, 30]
console.log(x, y, z)

// 4) 객체에 특정 프로퍼티의 값들을 뽑아서 한 번에 변수에 저장하는 방법
var obj = {
  name: '홍길동',
  age: 20,
  tel: 111-1111,
  email: 'hong@gmail.com'
}

// obj객체에서 name, age를 뽑아내고 싶을때

/* 4-1) 기존 방식
var name = obj.name
var age = obj.age
console.log(name, age)
*/

// 4-2) obj객체의 name과 age를 뽑아내서 한 번에 변수에 저장한다. 예) name프로퍼티값을 name변수에 저장.
var {name, age} = obj // obj의 프로퍼티명만 올 수 있다.
console.log(name, age)

var {age, email} = obj
console.log(age, email)
