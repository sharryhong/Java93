/* 주제: 상수 변수 - const
- 값을 한 번 할당하면 값을 변경할 수 없다.
*/
"use static"

var name = "홍길동";
name = "임꺽정";
console.log(name);

let name2 = "Hong";
name2 = "Goo";
console.log(name2);

const name3 = "Hong";
name3 = "Goo"; // 상수변수는 값 변경할 수 없다.
console.log(name3);
