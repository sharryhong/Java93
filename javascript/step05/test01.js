/* 주제: 객체 - 소개
- 객체는 문자열로 이름을 붙인 값들의 집합이다.
- 배열은 숫자로 이름을 붙인 값들의 집합이다.
*/

"use strict"
/* 참고
소스 파일의 첫 명령어로 "use strict"를 선언하면
자바스크립트 문법을 엄격하게 검사한다.
또는 node를 실행할 때 다음과 같이 실행 아규먼트 "--use-strict"를 지정해도 된다.
> node --use-strict test01.js
 */

// 배열? 숫자(인덱스)를 붙여 값을 저장한다.
var names = []; // 빈 배열을 꼭 만들어야 한다. 안만들면 undefined
names[0] = "홍길동"
names[1] = "임꺽정"
names[2] = "유관순"
console.log(names)

// 배열의 값을 꺼내보자.
console.log(names[0])
console.log(names[1])
console.log(names[2])
console.log("--------------------------------------")


// 객체? 문자열을 붙여 값을 저장한다.
var obj = {}
obj["name"] = "홍길동"
obj['name2'] = "임꺽정"
obj.name3 = "유관순" // 가장 많이 쓴다. (간편)

var v = "name4"
obj[v] = "윤봉길"

console.log(obj)

// 객체의 값을 꺼내보자.
console.log(obj["name"])
console.log(obj['name'])
console.log(obj.name) // 가장 많이 쓴다.
var v2 = 'name'
console.log(obj[v2])

console.log("--------------------------------------")

// 용어정리
// 객체에 저장하는 값을 보통 "프로퍼티(property)"라고 부른다.
// 값을 저장할 때 사용하는 문자열을 "프로퍼티명"이라고 부른다.
// 프로퍼티 이름에 특수문자나 공백 등이 포함되어 있을 때는
// "객체.프로퍼티명" 형식으로 값을 저장할 수 없다.
// "객체[프로퍼티명]" 형식으로 값을 저장해야만 한다.

// obj.first name = "길동"        // No!!!
obj["first name"] = "길동"        // ok
obj['hello^^;'] = "오호라~"       // ok
// console.log(obj.first name)   // No!!!
console.log(obj["first name"])   // ok
console.log(obj['hello^^;'])     // ok
