/* 주제: 배열 사용법 I
- 배열의 길이 알아내기
배열명.length

- 배열 초기화시키기
var 배열명 = [값, 값, 값, ...];

- 배열에 값을 추가하기
배열명[인덱스] = 값;

- 값 꺼내기
배열명[인덱스]

- 배열에는 서로 다른 종류의 값을 넣을 수 있다.
*/
"use static"

var a1 = [];
console.log(a1.length);

var a2 = [10, 20, 30, 40];
console.log(a2.length);
console.log("---------------------");

a1[0] = 100;
a1[1] = 200;
console.log(a1.length);

a1[100] = 300;
console.log(a1.length); // 0 부터 시작하니까 101.
                        // JAVA는 배열크기 정해지면 바꿀수없다. JS가 유연한 것.
console.log("---------------------");

// 값 꺼내기
console.log(a1[0]);
console.log(a1[1]);
console.log(a1[2]); // undefined. index의 범위이지만 값을 넣지 않은 항목
console.log(a1[101]); // undefined. index의 범위 벗어난 항목
                      // JAVA는 예외사항 발생

// 배열에 다른 종류의 값을 섞어 넣기
a2[4] = "홍길동";
a2[5] = false;
a2[6] = function() {};
a2[7] = null;
a2[8] = {};

for(var i = 0; i < a2.length; i++) {
  console.log(i, ":", a2[i]);
}
