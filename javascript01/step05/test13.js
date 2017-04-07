/* 주제: 객체 - this 변수의 활용
*/

"use strict"

var obj = {
  v1: 0,
  f1: function() {
    //
    // v1 = 100  // Error! v1 is not defined
              // global변수에도 없고 f1() 로컬변수에도 없어
              // (JAVA에서는 this생략가능. 컴파일시 자동으로 붙는 것 뿐이다.)
    this.v1 = 100 // this에 obj객체의 주소를 갖고있기 때문이다. 즉, this(주소) = obj(주소)
  }
}

obj.f1() // obj 주소로 가서 f1()을 호출하라.
console.log(obj.v1);
console.log('---------------------------------')

/* 전에 배운 방식. 위와 같은 것이다. 빈 객체를 만든다음에 값 저장
var obj2 = {}
obj2.v1 = 0
obj2.f1 = function() {
  v1 = 100
}

console.log(obj2);
*/
