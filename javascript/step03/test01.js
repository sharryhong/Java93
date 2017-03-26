/* 주제: 사용자에게서 입력 받기
- 외부에서 제공하는 'prompt'라는 nodeJS 모듈(=라이브러리=컴포넌트=플러그인)을
  추가해야 한다. 그래야 NodeJS에서 사용할 수 있다.
> npm install 모듈명
> npm install prompt

- 소스 코드에서 모듈을 사용하려면 NodeJS에게 요구해야 한다.
var 모듈을가리키는변수명 = require('모듈명');
*/
"use strict"

// 모듈 가져오기
var prompt = require('prompt');

// Start the prompt
prompt.start();

// 사용자로부터 'name', 'tel'을 입력받기
/* prompt.get(입력받을 항목의 배열, 입력받은 후에 호출될 함수);
*/
prompt.get(['name', 'tel'], function(error, result) { // prompt가 함수를 실행시킨다.
  console.log("입력결과");
  // console.log(result);
  // 입력값은 result 객체에 들어있다.
  console.log("이름 : ", result.name);
  console.log("전화번호 :",result.tel);
  console.log("error", error);
});
