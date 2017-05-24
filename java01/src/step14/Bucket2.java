package step14;

public class Bucket2<T> { // <> : 클래스에서 파라미터로 받을 변수. 타입(클래스 또는 인터페이스)정보를 받는 것
                          // 길게 적지 않는다. 타입정보를 받는다고해서 보통 T라고 적는다. 
  T value;
  
  public void setValue(T value) {
    this.value  = value;
  }
  
  public T getValue() {
    return value;
  }
}
