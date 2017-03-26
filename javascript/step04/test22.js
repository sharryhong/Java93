/* 주제: 함수 - 클로저(closure)
- 함수 안에서 만든 함수를 클로저라 부른다.
- 클로저에서 사용하는 메모리는 별도 관리한다.
*/

"use strict"

var arr = ['홍길동', '임꺽정', '유관순', '안중근', '윤봉길']
var count = -1;

// 클로저가 자체 변수를 사용하기 전
// 클로저는 글로벌 변수 count를 사용한다.
function outer() {
  count++;
  return function() { // 굳이 이름을 가질 필요없다.
    console.log(arr[count])
  }
}

var f1 = outer();
var f2 = outer();
var f3 = outer();
var f4 = outer();
var f5 = outer();

f1(); // 호출되는 시점에서 count는 이미 4이다.
f2(); // 호출되는 시점에서 count는 이미 4이다.
f3(); // 호출되는 시점에서 count는 이미 4이다.
f4(); // 호출되는 시점에서 count는 이미 4이다.
f5(); // 호출되는 시점에서 count는 이미 4이다.
