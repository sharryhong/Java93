/* 주제: setTimeout(callback, delay[, ...args])
- 한번만 호출됨
*/

// 이렇게도 할 수 있지만, f1()이 setTimeout의 콜백함수라는 것이 명시적이지 않아 코드가 길어질 경우 찾기 힘들 수 있다.
function f1() {
  console.log('1초 지났음')
}
setTimeout(f1, 1000)
console.log('첫번째 timeout 함수를 심었다.')

// 따라서 setTimeout안에 넣자. (실무)
// 개발자들이 '함수 넘겨'라고 말하지만 사실은 함수의 주소를 넘기는 것이다.
setTimeout(function() {
  console.log('3초 지났음')
}, 3000)
console.log('두번째 timeout 함수를 심었다.')

/* => "비동기 방식 호출"임을 알 수 있다.
  자바스크립트는 비동기방식이 엄청 많다. 주의!
*/
