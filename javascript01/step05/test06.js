/* 주제: 객체 - 함수를 이용하여 객체를 생성하기
*/

"use strict"

function createScore(name, kor, eng, math) {
  return { // 빈 객체를 만들고 (변수의 )값을 주기
    // 프로퍼티명: 파라미터 값 (실무에서 이렇게 쓴다.)
    name: name,
    kor: kor,
    eng: eng,
    math: math,
    sum: kor + eng + math,
    aver: (kor + eng + math) / 3
  }
}

var score2 = [
  createScore("홍길동1", 100, 100, 100),
  createScore("홍길동2", 90, 90, 90),
  createScore("홍길동3", 80, 80, 80),
  createScore("홍길동4", 70, 70, 70),
  createScore("홍길동5", 60, 60, 60)
]
console.log(score2)
console.log("홍길동3의 총점: " + score2[2].sum)
console.log('-----------------------------------')
