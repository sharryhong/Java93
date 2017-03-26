/* 주제 : 함수 - 연습. 실습
> 쌤의 코딩
-------------------------------
*/

"use strict"

// 1단계 : 사용자로부터 command값 입력받기
// 2단계 : 입력 반복받기
// 3단계 : 'quit' 명령 처리하기. 입력받으면 끝내기
// 4단계 : 'list', 'add', 'delete' 명령 구분하기
// 5단계 : 명령을 구분할때 if문 대신 switch문 사용
// 6단계 : 'list' 명령 처리하기
// 7단계 : 'add' 명령 처리하기
// 8단계 : 'delete' 명령 처리하기
// 9단계 : function 문법을 이용하여 명령어를 블록으로 묶어 관리한다.
// 10단계 : default도 분리, 다른건 return으로 끝나니 break없애고 return으로 통일해보자.
// 11단계 : 내일 배울 것     => 만들수록 복잡해진다.
var prompt = require('prompt')

// 실무에서도 예) 게시판시 미리 입력해놓고 테스트하면서 진행한다.
var studentList = [
  ["홍길동1", 100, 100, 100, 300, 100],
  ["홍길동2", 90, 90, 90, 270, 90],
  ["홍길동3", 80, 80, 80, 240, 80],
  ["홍길동4", 70, 70, 70, 210, 70],
  ["홍길동5", 60, 60, 60, 180, 60]
]

prompt.start()

// 함수를 동기 호출
inputCommand()

// 첫번째는 입력받을 이름, 두번째는 입력완료 후 실행할 콜백함수
// prompt.get()은 비동기식이다. 따라서 만약 for( prompt.get() ) 이렇게하면 한꺼번에 실행된다.
// 따라서 동기방식인 함수로 감싼다.
function inputCommand() {
  prompt.get(['command'], function(error, result) {
    switch (result.command) {
    case 'quit':
      doQuit()
      return // 함수 실행을 끝낸다.
    case 'list':
      doList()
      // break // 끝내는게 아니라, switch문의 다음 명령을 실행한다.
      return; // 10단계 : 모두 return이니까 얘도 바꾸자.
    case 'add':
      doAdd()
      return
    case 'delete':
      doDelete();
      return
    default:
      doDefault();
    }
    // inputCommand를 호출하면 그 전 작업은 즉시 끝난다(비동기방식) -> 새로운 작업 시작
    // 즉, 현재 작업은 하나이다.
    // inputCommand() // 10단계 : 더이상 필요가 없다.
  })
}

function doQuit() {
  console.log('안녕히 가세요')
}

function doList() {
  console.log('[학생 목록]')
  var count = 0;
  for (var student of studentList) {
    console.log(count++ + ":" + student[0] + "," +
                student[1] + "," +
                student[2] + "," +
                student[3] + "," +
                student[4] + "," +
                student[5])
  }
  inputCommand()
}

function doAdd() {
  console.log('[학생 입력]')
  // prompt.get([], function(error, result) {}); // 무엇을 입력받고, 입력받은 것을 가지고 무엇을 할건지.. 틀을 먼저 만든다.
  prompt.get(['name', 'kor', 'eng', 'math'], function(error, result) {
    var student = [result.name,
                  parseInt(result.kor),
                  parseInt(result.eng),
                  parseInt(result.math)]
    student[4] = student[1] + student[2] + student[3]
    student[5] = student[4] / 3
    studentList[studentList.length] = student // studentList 마지막 index에 추가
    console.log('입력되었습니다.')
    inputCommand() // 비동기방식이기 때문에 이렇게 하지않으면 맨 아래 inputCommand()가 같이 실행된다.
  })
}

function doDelete() {
  console.log('[학생 삭제]')
  prompt.get(['no'], function(err, result) {
    var no = parseInt(result.no)
    // 요새 트랜드 : if else를 쭉쭉 쓰기보다는 아래처럼
    // line수는 늘었지만 소스코드해석할 땐 훨씬 낫다.
    // 아래 if들은 걸러내기 위한 작업일 뿐, 맨 아래 "원래 해야할 작업"이 주인공!
    if (studentList.length == 0) {
      console.log('삭제할 항목이 없습니다')
      inputCommand()
      return
    }
    if (no < 0 || no > studentList.length) {
      console.log('학생 번호가 옳지 않습니다')
      inputCommand()
      return
    }
    // 원래 해야할 작업
    studentList.splice(no, 1); // 배열 내장에 장착된 기능 사용
    console.log('삭제했습니다')
    console.log()
    inputCommand()
  })
}

function doDefault() {
  console.log('해당 명령은 지원하지 않습니다.')
  inputCommand()
}
