/* 주제: Object() - 기본 사용법
*/

// 1) 함수로 사용해보자.
//
var obj1 = new Object() // Object()는 함수객체라는 것을 잊지말자.
var obj2 = {} // new Object() 명령의 단축코드
// console.log(obj1, obj2) // 같다는 걸 알 수 있다.
/*
지금까지는 위처럼 객체를 만들면 빈 객체라고 말했으나,
객체에 필요한 최소한의 프로퍼티는 가지고 있다. 아래에서 Object()의 인스턴스함수, 일반 함수 사용해보자.
*/

//
var obj2 = {
  name: "홍길동",
  age: 20
}

// 2) 인스턴스 함수를 사용해보자 Object.prototype.hasOwnProperty()
console.log(obj2.hasOwnProperty('name')) // true
console.log(obj2.hasOwnProperty('age')) // true
console.log(obj2.hasOwnProperty('tel')) // false
// obj2객체에 hasOwnProperty() 찾아본다.
// 없으면 Object() 에서 찾아본다.

// 3) 함수 객체에 보관된 일반 함수를 사용해보자. Object.create()
var obj3 = Object.create(null) //
console.log(obj3);
