/* 주제: 객체 - 일반 객체와 함수 객체
*/

"use strict"

// 일반 객체
var obj1 = {
  name: "홍길동",
  age: 20
}

obj1.tel = '111-1111' // 객체에 값 보관
obj1.f1 = function() {console.log('hello');} // 객체에 함수 보관
obj1.ok = {} // 객체에 객체 저장

// 함수 객체 : 함수코드를 갖고 있다. prototype이 있다.
var obj2 = function() {
  console.log('test!');
}
// 함수도 객체이기 때문에 아래처럼된다.
obj2.tel = '222-2222'
obj2.f1 = function() {console.log('hello');}
obj2.ok = {}

// 함수 객체의 코드 실행
obj2()

/*
그런데~! 용도에 맞게 쓰도록하자.
*/
