/* 주제: 함수 - 재귀호출
- 함수를 호출한 후 다시 자기 자신을 호출하기
- 코드가 간단해 진다.
- 반복문을 사용하기 보다 속도가 느리다. 메모리를 많이 사용한다.
- 너무 깊게 호출하면 스택 메모리가 부족하여 오류가 발생할 수 있다.
*/

"use strict"

// 시그마(Σ)(1~n까지의 합) 구현
// 1_ Sigma(n)반복문으로 구현
var sum = 0
for (var i = 1; i <= 5; i++) {
  sum += i
}
console.log(sum) // 15
// 디버그 실행해보면 for문은 스텍이 한번쌓이는것을 알 수 있다.

// Sigma(n)을 재귀호출로 구현하기
/*
sigma(n) = n + sigma(n - 1)
               = (n - 1) + sigma(n - 2)
*/
// 장점 : 수학공식을 그대로 쓸 수 있다. 코드가 간단해진다. 직관적이다.
// 단점 : 속도가 느리고 메모리를 많이 사용한다.
function sigma(n) {
  if (n == 1)
    return 1
  return n + sigma(n -1)
}

var sum2 = sigma(5)
console.log(sum2)
