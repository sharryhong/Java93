/* 주제: 연산자 - delete
-
*/
"use strict"

var v1 = 100
console.log(v1)

// delete v1 // Error!
console.log('------------------------------')

var obj = {}
obj.v1 = 100
console.log(obj.v1) // 100

delete obj.v1 //
console.log(obj.v1) // undefined
