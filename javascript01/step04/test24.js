/* 주제 : 함수 - 클로저(closure) 3
- 글로벌 변수와 블록 제한 변수
*/

"use strict"

var arr = ['홍길동', '임꺽정', '유관순', '안중근', '윤봉길']
var functionList = []

for (var i = 0; i < arr.length; i++) {
  functionList[i] = function() {
    console.log(arr[i]) // i는 전역변수이다. 즉, 따로 복제하지 않는다.
  }
}

console.log(i) // i = 5
functionList[0](); // index 0 인 함수를 실행하라. 그런데 i = 5이기때문에, arr[5]는 없기 때문에 undefined이다.
