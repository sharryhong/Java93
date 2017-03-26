/* 주제: 배열과 변수. 레퍼런스(참조) 타입 : 메모리 주소 저장

*/
"use static"

// 2,3,4...차원 배열이 아니라 1차원 배열이다.
// 배열 안에 배열이 있을 뿐이다.
var a1 = ["홍길동", 99, 98, 97];

console.log(a1[1]);

var v1 = a1;
a1[1] = 88;
console.log(v1[1]);


var x = 10;
var y = x;
x = 20;
console.log(y);
