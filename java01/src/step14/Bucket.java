package step14;

public class Bucket {
  Object value; // 어떤 객체주소라도 담을 수 있는 레퍼런스 변수 
  
  public void setValue(Object value) {
    this.value  = value;
  }
  
  public Object getValue() {
    return value;
  }
}
