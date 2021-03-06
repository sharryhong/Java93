/* 주제: 배열 사용법 II
- 배열 안에 배열을 넣을 수 있다.
- 다차원 배열의 항목을 지정하기
배열명[인덱스1][인덱스2]

*/
"use static"

// 배열 형식 : 이름, 국어, 영어, 수학
// 2,3,4...차원 배열이 아니라 1차원 배열이다.
// 배열 안에 배열이 있을 뿐이다.
var a1 = [["홍길동", 99, 98, 97], ["임꺽정", 89, 88, 87], ["유관순", 79, 78, 77]];
console.log(a1[1][3]); // 임꺽정의 수학점수
console.log(a1.length); // 3
console.log(a1[2].length); // 4
