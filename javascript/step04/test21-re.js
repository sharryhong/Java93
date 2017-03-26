/* 주제 : 종합 실습 1
- 쌤의 노하우 습득하기!!
*/

"use strict"

// 모듈 가져오기
var prompt = require('prompt');

var students = [["홍길동1", 100, 90, 80, 270, 90],
                ["홍길동2", 100, 90, 80, 270, 90]];

var commandHandlerMap = {
  'quit': doQuit,
  'list': doList,
  'add': doAdd,
  'delete': doDelete,
}

prompt.start();

inputCommand()

function inputCommand() {
  prompt.get(['command'], function(err, result) {
    var command = commandHandlerMap[result.command]
    if (command) {
      command()
    } else {
      doDefault()
    }
  })
}

function doQuit() {
  console.log('종료되었습니다.')
}

function doList() {
  console.log('학생 목록')
  // 학생 목록을 출력하기 위해 students배열의 index와 value를 받아 출력한다.
  for (var i in students) {
    console.log(i + ": " + students[i])
  }
  inputCommand()
}

function doAdd() {
  console.log('학생 추가')
  // name, kor, eng, math값을 입력(prompt필요)받아 배열 끝에 추가시킨다.
  prompt.get(['name', 'kor', 'eng', 'math'], function(err, result) {
    var addStudent = [
      result.name,
      parseInt(result.kor),
      parseInt(result.eng),
      parseInt(result.math)
    ]
    addStudent[4] = addStudent[1] + addStudent[2] + addStudent[3]
    addStudent[5] = parseInt(addStudent[4] / 3)
    students[students.length] = addStudent
    console.log(addStudent)
    inputCommand()
  })
}

function doDelete() {
  console.log('학생 삭제')
  // index no값을 입력받아 students배열에서 해당 index의 값을 삭제한다.
  // 입력숫자가 0미만이거나 students.length보다 크면 안된다.
  // students.length가 0이면 목록없다고 하고 끝내기
  prompt.get(['number'], function(err, result) {
    var no = result.number
    if (students.length == 0) {
      console.log('학생 목록이 없습니다.')
      inputCommand()
      return
    }
    if (no < 0 || no >= students.length) {
      console.log('해당 학생이 없습니다.')
      inputCommand()
      return
    }
    var delStudent = students[no] // parseInt안했는데 숫자로 인식하네?
    students.splice(no, 1)
    console.log(delStudent[0] + '삭제되었습니다.')
    inputCommand()
  })
}

function doDefault() {
  console.log('list, add, delete, quit 명령만 실행됩니다')
  inputCommand()
}
