/* 애노테이션 사용하기 : 속성 값 설정하기
 */ 
package step25;

@Annotation04(v1 = "hello", v3 = 200) // v1, v3는 필수 속성이기 때문에 반드시 입력해야한다.
                                      // v2, v4는 선택 속성이기 때문에 생략가능, 생략하면 default값 사용됨
public class Class02 {

}
