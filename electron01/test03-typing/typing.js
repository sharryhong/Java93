'use strict'
window.$ = window.jQuery = require('jquery')

let words = [],         // json data
    correctWords = [],  // 정답 data
    wrongWords = [],    // 오답 data
    currentWord = null, // 랜덤으로 뽑힌 단어
    randomIndex = null, // 랜덤으로 뽑힌 단어의 인덱스
    sec = 60,
    showWord = $('#show-word'),
    showSec = $('.show-sec'),
    inputText = $('#input-text');

inputText.attr('disabled', 'disabled')

// json파일내의 데이터를 랜덤으로 뿌려줌
$.getJSON("words.json", function(data) {
  words = data.words
  randomWord()
})

function randomWord() {
  randomIndex = Math.floor(Math.random() * words.length)
  currentWord = words[randomIndex]
  showWord.text(currentWord)
}

$('#start-btn').click(function() {
  var that = $(this)
  $(this).css("display", "none")
  inputText.removeAttr('disabled')
  inputText.focus() // inputText에 포커스
  var interval = setInterval(function() {
    sec--
    showSec.text(sec)
    if (sec == 0) {  // 끝나면
      sec = 60
      showSec.text(sec)
      clearInterval(interval)
      that.css("display", "inline-block")
      inputText.attr('disabled', 'disabled')
    }
  }, 1000)
})

inputText.keypress(function(event) {
  if (event.keyCode === 13 || event.which === 13) { // enter키
    let answerWord = $(this).val() // 입력 값
    $(this).val('') // 입력 값 비우기
    if (answerWord == currentWord) { // 정답일 때
      words.splice(randomIndex, 1)   // 원본 배열에서 삭제
      correctWords.push(currentWord) // 정답 배열에 추가
      randomWord()
      console.log("정답", correctWords);
    } else { // 오답일 때
      wrongWords.push(currentWord)    // 오답 배열에 추가
      randomWord()
      console.log("오답", wrongWords);
    }
    console.log(words);
  }
})
