// a, b값을 입력받아서 +, -, *, /, % 를 계산하는 프로그램

"use strict"

// 모듈 가져오기
var prompt = require('prompt');

// Start the prompt
prompt.start();

prompt.get(['a', 'b'], function(error, result) {
  // result값은 string으로 들어간다.
  var a = parseInt(result.a); // String -> Number
  var b = parseInt(result.b);
  console.log("계산결과");
  console.log("a + b = ", a + b);
  console.log("a - b = ", a - b);
  console.log("a * b = ", a * b);
  console.log("a / b = ", a / b);
  console.log("a % b = ", a % b);
});
