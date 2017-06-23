/* 애노테이션
 * => 클래스 앞, 필드 앞, 메서드 앞에 붙이는 특별한 주석
 * => 컴파일러나 JVM에서 꺼내쓴다.
 * => 특정 값을 갖도록 형식을 정의할 수 있다. 
 * 
 * 문법 : 인터페이스와 유사하다.
 */
package step25;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 유지 범위를 지정하지 않으면 다음의 애노테이션이 자동으로 붙는다. 
//@Retention(RetentionPolicy.CLASS)
public @interface Annotation01 {

}
