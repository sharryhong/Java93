/* 주제: 객체 - 생성자와 this 변수
- 생성자라고 해서 특별한 문법이 있는 것이 아니다.
  단지 그냥 함수일 뿐이다.
  그리고 new 연산자 다음에 곧바로 호출한다는 것 뿐이다.
- new 연산자가 만든 빈 객체를 사용하려면 그 객체 주소를 알아야 한다.
- new 연산자 다음에 곧바로 함수를 호출하면
  함수에 this라는 변수가 생성되고 그 변수 안에 객체 주소가 자동으로 저장된다.
- new 연산자 다음에 곧바로 호출하지 않고 그냥 호출하면
  this 변수는 생기지 않는다.
*/

"use strict"

function init() {
  console.log(this)
}

new init()  // new 다음에 곧바로 호출하기 => init ()
init()      // 그냥 호출하기             => undefined. 즉, this를 쓸 수 없다.

// var obj = new init() // {} 빈 객체 대신, new연산자 사용
// console.log(obj)
