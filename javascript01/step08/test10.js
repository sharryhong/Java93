// 공통으로 사용할 JS코드 - mini jQuery를 만들어보자.
"use strict"
// 1. querySelectorAll 많이쓴다. 줄여보자.
// querySelector의 경우 [0]을 주면된다.
// 2. createElement도 해보자.
function bit(value) {
  // 리턴값으로써 배열로 만든다. element들이 담길 배열
  // console.log("value=", value)
  var el = []
  // 파라미터값이 태그라면
  if (value instanceof HTMLElement) {
    el[0] = value // 무조건 태그를 배열로 포장한다.
                  // 배열에 들어있는 플러그인을 쓰기 위해
    // console.log(value)
    // console.log('case1', value)

  // 예) $("<tr>"). 시작 문자가 "<"이면, 새 태그 생성으로 간주
  } else if (value.startsWith('<')) {
    // < 빼고 태그 이름만 들어가도록
    el[0] = document.createElement(value.substr(1, value.length - 2))
    // console.log('case2', value)

  // css selector문법으로 간주
  } else {
    var list = document.querySelectorAll(value)
    for (var e of list) {
      // 순수한 배열로 반환하기 위해, 또한 원본인 list에는 원래 있는 함수도 있을 수 있다.
      // el배열에 아래처럼 함수를 붙여도 안심
      el.push(e)
      // console.log('case3', e)
    }
  }

  /* 플러그인들 : 배열에 나만의 유용한 함수를 붙이자! */
  // 1) 배열에 들어있는 태그에 대해 자식 태그를 추가하는 아주 편리한 함수
  el.append = function(children) { // children에 배열만 들어오게끔하자.
    if (!(children instanceof Array)) { // 배열이 아니면
      console.error('배열이 아닙니다.')
      return
    }
    for (var e of this) {
      for (var child of children) {
        e.appendChild(child)
      }
    }
    return this // 자기자신(배열) 주소 리턴
  }

  // 2) 배열 안에 있는 태그의 콘텐츠를 설정하는 함수
  el.html = function(content) {
    for (var e of this) {
      e.innerHTML = content
    }
    return this
  }

  // 3) 배열 안에 있는 태그에 클릭 이벤트 핸들러를 추가하는 함수
  el.click = function(listener) {
    for (var e of this) {
      e.addEventListener('click', listener)
    }
    return this
  }

  // 4) 배열 안에 있는 태그의 속성 값을 다루는 함수
  // => 개발자가 태그에 추가한 속성을 다룬다.
  // => 속성을 값을 꺼낼 때는 getAttribute()를 사용하고,
  //    속성의 값을 넣을 때는 setAttribute()를 사용한다.
  // => 태그에 원래 있던 속성에 대해서도 사용할 수 있는데,
  //    "checked"와 같은 일부 속성은 적용할 수 없다.
  // jquery가 이렇게 되어있다.
  el.attr = function(name, value) {
    if (arguments.length < 2) { // 특정 이름을 가진 속성의 값을 꺼낸다.
      // 값을 꺼낼 때는 배열에서 0번 방에 들어 있는 태그의 속성 값만 꺼내자!
      return this[0].getAttribute(name)
    } else { // 특정 이름을 가진 속성의 값을 value로 설정한다.
      for (var e of this) {
        e.setAttribute(name, value)
      }
    }
  }

  // 5) 배열 안에 있는 태그를 부모 태그에 추가시키는 함수
  el.appendTo = function(parents) { // 부모가 넘어온다(배열로). el은 자식을 담은 배열.
    for (var p of parents) {
      for (var e of this) { // 자식을 담은 배열
        p.appendChild(e) // 부모에 붙인다.
        // parents[parents.length-1].appendChild(this[this.length-1])
      }
    }
    return el
  }

  // 6) 배열 안에 있는 각각의 태그에 대해 CSS 스타일을 다루는 함수
  el.css = function(name, value) {
    for (var e of this) {
      e.style[name] = value
    }
    return this
  }

  // 7) 배열 안에 있는 태그의 콘텐츠를 설정하는 함수(textContent 속성)
  el.text = function(content) {
    for (var e of this) {
      e.textContent = content
    }
    return this
  }

  // 8) 배열 안에 있는 폼 항목 태그의 콘텐츠를 설정하는 함수(value 속성)
  el.val = function(value) {
    if (arguments.length == 0) {
      return this[0].value
    }
    for (var e of this) {
      e.value = value
    }
    return this
  }

  // 9) 배열 안에 있는 태그의 프로퍼티 값(?)을 다루는 함수
  //    => 개발자가 태그에 추가한 속성이 아닌 원래 있던 속성의 값을 다루는 함수
  //    => getAttribute()/setAttribute() 대신 "태그명.속성명", "태그명.속성명 = 값"으로 다룬다.
  el.prop = function(name, value) {
    if (arguments.length < 2) { // 특정 이름을 가진 프로퍼티 값을 꺼낸다.
      return this[0][name]
    } else { // 특정 이름을 가진 속성의 값을 value로 설정한다.
      for (var e of this) {
        e[name] = value
      }
    }
  }

  return el
}

// bit() 함수가 리턴한 배열에 대해 작업하지 않고,
// 독자적으로 작업하는 함수는 bit() 객체에 직접 보관한다.
bit.ajax = function(url, settings) { // settings : 설정정보를 객체로 받기
  if (settings == undefined) { // settings값이 안넘어올 때
    settings = {
      method: 'GET',
      dataType: 'text'
    }
  } else { // settings값이 넘어왔는데.. 즉, default설정
    if (settings.method == undefined) settings.method = 'GET'
    if (settings.dataType == undefined) settings.dataType = 'text'
  }
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState < 4)
      return

    var rv
    if (settings.dataType == 'json') {
      rv = JSON.parse(xhr.responseText)
    } else {
      rv = xhr.responseText
    }

    if (settings.success) { // 암시적 형변환이 일어나서, 값이있으면 true
      settings.success(rv) // settings 객체의 success 변수에 들어있는 함수를 호출한다.
                          // success는 함수여야한다.
    }
  }
  xhr.open(settings.method, url, true)
  if (settings.method == 'POST') {
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
    var queryString = ''
    if (settings.data) {
      for (var propName in settings.data) {
        if (queryString.length > 0) { // 처음에만 &가 안붙는다.
          queryString += '&'
        }
        queryString += propName + '=' + settings.data[propName]
      }
    }
    xhr.send(queryString)
  } else {
    xhr.send()
  }
}

bit.getJSON = function(url, success) {
  bit.ajax(url, {
    dataType: 'json',
    success: success
  })
}

// jquery에서는 옵션이 오지만, 쉽게하기 위해 조금 다르게 한다.
bit.post = function(url, data, success, dataType) {
  bit.ajax(url, {
    method: 'POST',
    dataType: dataType,
    data: data,
    success: success
  })
}

// Java에서는 $를 변수, 함수명으로 쓸 수 없으나, JavaScript에서는 쓸 수 있다.
// $가 눈에 잘 띄어서, 잘 쓰인다.
var $ = bit; // bit로 써도 되고, $로 써도되게
