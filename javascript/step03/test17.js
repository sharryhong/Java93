/* 주제: 흐름 제어문 - 연습
- 구구단을 출력하는 프로그램을 작성하시오.
- 예)
> node test17.js
prompt: step: 5
5 * 1 = 5
5 * 2 = 10
...
5 * 9 = 45
*/

"use strict"

// 모듈 가져오기
var prompt = require('prompt');

// Start the prompt
prompt.start();

prompt.get(['step'], function(error, result) {
  // result값은 string으로 들어간다.
  var step = parseInt(result.step); // String -> Number

  for (var i = 1; i <= 9; i++) {
    console.log(step + " * " + i + " = " + (step * i));
  }
  // var i = 1;
  // while (i <= 9) {
  //   console.log(num + " * " + i + " = " + (num * i));
  //   i++;
  // }

});
