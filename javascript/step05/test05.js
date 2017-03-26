/* 주제: 객체 - 용도. 언제쓰는가?
- 여러 개의 데이터를 한 단위로 묶어서 다루고 싶을 때 => 배열과 객체
- 각각의 값을 코드에서 쉽게 구분하고 싶을 때 => 객체. 왜? 이름으로 구분하기 쉽다.
- 여러 개의 함수를 묶어서 관리하고 싶을 때
*/

"use strict"

// 학생의 이름 및 성적 정보를 배열에 저장한다.
var scores = [
  ["홍길동1", 100, 100, 100, 300, 100],
  ["홍길동2", 90, 90, 90, 270, 90],
  ["홍길동3", 80, 80, 80, 240, 80],
  ["홍길동4", 70, 70, 70, 210, 70],
  ["홍길동5", 60, 60, 60, 180, 60]
]

console.log("홍길동3의 총점: " + scores[2][4])
console.log('-----------------------------------')

// 객체
// 직접적으로 값을 주는 것 : Literal (글자 그대로의)
var scores2 = [
  {name: "홍길동1", kor: 100, eng: 100, math: 100, sum: 300, aver: 100},
  {name: "홍길동2", kor: 90, eng: 90, math: 90, sum: 300, aver: 90},
  {name: "홍길동3", kor: 80, eng: 80, math: 80, sum: 300, aver: 80},
  {name: "홍길동4", kor: 70, eng: 70, math: 70, sum: 300, aver: 70},
  {name: "홍길동5", kor: 60, eng: 60, math: 60, sum: 300, aver: 60}
]

console.log("홍길동3의 총점: " + scores2[2]['sum'])
console.log('-----------------------------------')
