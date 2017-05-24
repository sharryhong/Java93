/* 제네릭(Generic) 문법 사용 전 
 * => 값을 꺼낼 때마다 본래 타입으로 형 변환 해야하는 번거로움*/
package step14;

public class Test01 {

  public static void main(String[] args) {
    Bucket b = new Bucket();
    
    String str = new String("Hello");
    System.out.println(str.length());

    b.setValue(str);
//    String str2 = b.getValue(); // Error! b.getValue()의 리턴타입이 Object이다. 실제로는 String이 들어가있지만.
                                  // 절대 하위 레퍼런스타입은 상위 타입을 가리킬 수 없다. 
    String str2 = (String)b.getValue(); // b.getValue() 실제 값은 String이므로 이렇게 형변환할 수 있다. 
  }

}
