/* 주제: 객체 - this 변수
*/

"use strict"

//
function f1() {
  console.log(this);
}

// new 연산자를 통해 함수를 호출할 때 객체의 주소를 넘기는 경우
new f1() // this가 생성된다. this가 가르키는 주소의 값인 f1()이 출력된다.
// this는 new를 통해 주소가 전달되어야 생성된다.



// 만약 객체의 주소를 주지 않고 그냥 호출하는 경우
// f1() // this.가 생성되지 않는다. undefined
//
//
// //
// var obj = {
//   f2: function() {
//     console.log(this)
//   }
// }
//
// //
// obj.f2()
// //
// // f2() // Error! global function으로 f2()가 없다.
