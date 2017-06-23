/* 주제: 예외처리 - throw
=> 프로그램을 실행하는 도중 예외 상황이 발생했을 때,
  예외 정보를 호출할 쪽에 알리는 명령어
*/

"use strict"

// throw 명령어가 없던 시절
function divide(a, b) {
  if (b == 0) // 0으로 나누려 한다면
    return -12121212 // 리턴 값으로 나오기 희박한 수를 리턴한다.
  return a / b // 그 밖에는 정상 값 리턴
}

var result = divide(10, 2)
console.log(result)

// 리턴 값으로 오류 정보를 알려주기 때문에 함수를 호출한 후 항상 그 리턴값을 검사해야한다.
// 그런데 이것도 완벽하지 않다.
// => 오류 알리기 위한 리턴값과 같은 값을 생성하는 경우도 있다. 이런 경우를 처리할 수 없다.
result = divide(10, 0)
if (result == -12121212) {
  console.log('0으로 나눌 수 없습니다.')
} else {
  console.log(result);
}
