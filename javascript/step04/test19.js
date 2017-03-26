/* 주제 : 함수 - 함수 호출 동기 방식과 비동기 방식
*/

"use strict"

// 동기방식 1
/*
function f1() {
  console.log("f1() 호출됨")
  // 여기에서 무한루프에 빠지게 하면
  while (true) {}
}

f1();

console.log("Hello~") // 실행되지 않는다.
*/

// 동기방식 2
function f1() {
  console.log("f1() 호출됨")
  // 부동소수점 연산, 나누기가 시간이 오래걸린다. : 3D 게임 등.. 그래서 좋은 그래픽카드 cpu필요 (예: geforce cpu)
  // 그래픽카드는 거의 부동소수점 연산을 위해 만들어졌다.
  for (var i = 0; i < 1000000000; i++) {
    var d = 3.141592;
    var d2 = 3456.987;
    var result = d / d2;
  }
}

f1();

console.log("Hello~") // 위 함수 작업이 끝날 때 까지 실행되지 않는다.
