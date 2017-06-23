/* 애노테이션 사용하기 : 배열 속성 값 설정하기
 */ 
package step25;

@Annotation05(
    v1 = {"aaa", "bbb", "cccc"}, 
    v2 = {"xxx"}, 
    v3 = "mmm", // 배열 값을 한개만 지정하면 {} 생략 가능 
    v4 = {100, 200, 300}, 
    v5 = {1000}, 
    v6 = 111)   // 배열 값을 한개만 지정하면 {} 생략 가능
public class Class03 {

}
