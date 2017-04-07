/* 주제 : 함수 - 클로저(closure) 4
- 글로벌 변수와 블록 제한 변수
*/

"use strict"

var arr = ['홍길동', '임꺽정', '유관순', '안중근', '윤봉길']
var functionList = []

// let 변수는 선언된 범위 안에서만 유효하다.
// 즉 그 범위를 벗어나면 로컬 변수처럼 제거된다.
// 그래서 let 변수도 클로저의 복제 대상이다.
for (let i = 0; i < arr.length; i++) {
  functionList[i] = function() {
    console.log(arr[i]) // i는 let변수이기 때문에 로컬 변수처럼 따로 복제한다.
  }
}

// console.log(i); // i는 let변수이므로 for문이 끝나면 제거된다.
functionList[0](); // 따로 복제되었기 때문에 '홍길동'이 제대로 나온다. arr[0]
functionList[1]();
functionList[2]();
functionList[3]();
functionList[4]();
