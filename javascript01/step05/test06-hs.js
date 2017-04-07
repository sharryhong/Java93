/* 주제: 객체 - 함수를 이용하여 객체를 생성하기
*/

"use strict"

function student(name, kor, eng, math) {
  return {
    name: name,
    kor: kor,
    eng: eng,
    math: math,
    sum: kor + eng + math,
    aver: (kor + eng + math) / 3
  }
}

var students = [
  student('홍길동1', 100, 100, 100),
  student('홍길동2', 90, 90, 90),
  student('홍길동3', 80, 80, 80),
  student('홍길동4', 70, 70, 70),
  student('홍길동5', 60, 60, 60),
]

console.log(students);
console.log('홍길동2의 평균점수는? ' + students[1].aver);
