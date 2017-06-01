package step23.ex12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 애노테이션(특별한 주석) // 일반 주석은 컴파일할 때 떨어져 나간다. 
// WebServlet이라는 애노테이션은 JVM을 실행할 때도 유지하라. 
@Retention(RetentionPolicy.RUNTIME)
public @interface WebServlet {
  String url();
}
