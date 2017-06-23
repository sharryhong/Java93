/* 주제: 변수 선언과 값 할당 II
*/
"use static"

var name = "홍길동";
var tel = "1111-2222";
var kor = 100;
var eng = 100;
var math = 100;
console.log(name, tel, kor, eng, math);

// 소스코드가 아름답게 보이게 위해 이 방법을 더 많이 쓴다.
// 어떤 변수가 쓰이는지 한 눈에 보인다.
var name2 = "임꺽정",
    tel2 = "222-2222",
    kor2 = 90,
    eng2 = 99,
    math2 = 93;
console.log(name2, tel2, kor2, eng2, math2);

/* 문자열 여러 줄 입력 */
// 방법 1) '+' 연산자를 사용하여 문자열 연결
var str = "안녕하세요." +
          "홍길동" +
          "입니다."
console.log(str)

// 방법 2)
var str2 = "안녕하세요 \
홍길동\
입니다."
console.log(str2)
