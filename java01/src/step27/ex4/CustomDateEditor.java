package step27.ex4;

import java.beans.PropertyEditorSupport;

// PropertyEditor인터페이스를 직접 구현하는 대신 PropertyEditorSupport 상속받기
public class CustomDateEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    // 파라미터로 넘어오는 값은 xml설정 파일에 지정한 문자열이다.
    // 이 문자열을 가지고 java.sql.Date 객체를 만들어 내부에 저장하면 된다.
    this.setValue(java.sql.Date.valueOf(text));
  }
}
