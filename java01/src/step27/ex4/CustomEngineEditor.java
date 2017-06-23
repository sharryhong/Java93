package step27.ex4;

import java.beans.PropertyEditorSupport;

public class CustomEngineEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    String[] values = text.split(","); // 값을 콤마 단위로 자른다.
    // engine객체를 만든다. 
    Engine engine = new Engine(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    this.setValue(engine);
  }
}
