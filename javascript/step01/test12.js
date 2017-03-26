/* 주제: let 변수의 중복 선언
- var 변수는 중복 선언하면 기존 변수를 덮어쓰지만,
  let 변수는 중복 선언할 수 없다. 오류를 발생시킨다.
*/
"use static"

var name = "홍길동";
var name = "임꺽정"; // 오류안남
console.log(name);

let name2 = "Hong";
let name2 = "Goo"; // 오류. 장점 : 프로그램을 더 정교하게 다룰 수 있다.
console.log(name2);
