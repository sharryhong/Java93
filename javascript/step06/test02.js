/* 주제: String() - 기본 사용법
*/

// 1) 함수로 사용해보자.
//
var str1 = new String("hello") // 문자열을 객체로 표현한다.
console.log(str1)
console.log(typeof str1) // object

// String() 인스턴스 함수를 사용해보자.
// String.prototype.length
console.log('str1의 문자열 길이: ' + str1.length) // 5
// String.prototype.charAt()
console.log(str1.charAt(0))
console.log('-------------------------------------------')

// 다음은 위의 명령문과 비슷하다. 같은건 아니다.
var str2 = "hello" // 문자열을 값으로 표현한다. 실무에선 거의 이렇게 쓴다.
console.log(str2)
console.log(typeof str2) // string

// String.prototype.length
console.log('str2의 문자열 길이: ' + str2.length) // string인데 되네! => JavaScript Engine이 해줌 
// String.prototype.charAt()
console.log(str2.charAt(0))
