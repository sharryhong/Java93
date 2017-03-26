/* 주제 : 함수 - 연습. 실습
> node test21.js
-------------------------------
prompt: command: list
[학생 성적 목록]
0: "홍길동1", 100, 90, 80, 270, 90
1: "홍길동2", 100, 90, 80, 270, 90
2: "홍길동3", 100, 90, 80, 270, 90
3: "홍길동4", 100, 90, 80, 270, 90
-------------------------------
prompt: command: add
[학생 성적 입력]
prompt: name: 홍길동5
prompt: kor: 100
prompt: eng: 100
prompt: math: 100
성적
이름: 홍길동5
국어: 100
영어: 100
수학: 100
합계: 300
평균: 100
-------------------------------
prompt: command: list
0: "홍길동1", 100, 90, 80, 270, 90
1: "홍길동2", 100, 90, 80, 270, 90
2: "홍길동3", 100, 90, 80, 270, 90
3: "홍길동4", 100, 90, 80, 270, 90
4: "홍길동5", 100, 100, 100, 300, 100
-------------------------------
prompt: command: delete
prompt: no: 2
"홍길동3"의 정보가 삭제되었습니다.
-------------------------------
prompt: command: list
0: "홍길동1", 100, 90, 80, 270, 90
1: "홍길동2", 100, 90, 80, 270, 90
2: "홍길동4", 100, 90, 80, 270, 90
3: "홍길동5", 100, 100, 100, 300, 100
-------------------------------
prompt: command: quit
안녕히 가세요!
>
*/

"use strict"

// 모듈 가져오기
var prompt = require('prompt');

var students = [["홍길동1", 100, 90, 80, 270, 90],
                ["홍길동2", 100, 90, 80, 270, 90],
                ["홍길동3", 100, 90, 80, 270, 90],
                ["홍길동4", 100, 90, 80, 270, 90]];

// Start the prompt
prompt.start();

var promptGet = function() {
  prompt.get(['command'], function(error, result) {
    global.command = result.command
    commands()
  });
}

var hr = function() {
  console.log('--------------------------')
}

var commands = function() {
  if (global.command == "quit") console.log('안녕히 가세요!');
  switch (global.command) {
  case "list":
    console.log('[학생 성적 목록]')
    for (var student in students) {
      console.log(student + ": " + students[student])
    }
  hr()
  promptGet()
  break
  case "add":
    console.log('[학생 성적 입력]')
    prompt.get(['name','kor','eng','math'], function(error, result) {
      var name = result.name,
          kor  = parseInt(result.kor),
          eng  = parseInt(result.eng),
          math = parseInt(result.math)
      var total = kor + eng + math
      var aver = parseInt(total / 3)
      students.push([name, kor, eng, math, total, aver])
      // console.log(students)
      console.log("성적")
      console.log("이름: " + name)
      console.log("국어: " + kor)
      console.log("영어: " + eng)
      console.log("수학: " + math)
      console.log("합계: " + total)
      console.log("평균: " + aver)
      hr()
      promptGet()
    });
  break
  case "delete":
    prompt.get(['no'], function(error, result) {
      var no = parseInt(result.no);
      var deleteValue = students[no];
      students.splice(no, 1);
      // console.log(students)
      console.log(deleteValue[0] + "의 정보가 삭제되었습니다.");
      hr()
      promptGet()
    });
  break
  }
}

promptGet()
