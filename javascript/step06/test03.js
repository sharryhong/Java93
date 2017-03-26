/* 주제: Array() - 기본 사용법
*/

// 1) 함수로 사용해보자.
//
var arr1 = new Array()
console.log(arr1)
console.log(typeof arr1) // object

var arr2 = [] // new Array()의 단축문법. 같은거니까 걍 이걸 쓰자.
console.log(arr2)
console.log(typeof arr2) // object

var arr3 = ['홍길동', '임꺽정', '유관순', '안중근']

// Array() 인스턴스 함수를 사용해보자.
console.log("배열 길이: " + arr3.length)
arr3.push('윤봉길')
arr3.push('김구', '신채호')
console.log("배열 길이: " + arr3.length)
console.log(arr3)

var value = arr3.pop()
console.log(value)
console.log(arr3)

value = arr3.shift()
console.log(value)
console.log(arr3)

value = arr3.splice(2, 1) // index 2에 해당하는 값을 1개 삭제
console.log(arr3)
value = arr3.splice(1, 3)
console.log(arr3)
