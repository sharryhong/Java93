/* 유틸리티 클래스 : Wrapper 3 - 오토 박싱(auto-boxing)
 * => 원시 데이터 타입과 랩퍼 클래스간의 전환을 자동으로 처리하는 것
 * boxing : 
 * unboxing :   
 */
package step08;

public class Test04_3 {

  public static void main(String[] args) {
    int a = 10;
    Integer obj = new Integer(20);
    
    // 개발자가 명시적으로 랩퍼객체에서 값을 꺼내기 
    int b = obj.intValue();
    int c = obj; // auto-unboxing : 랩퍼객체에서 값을 자동으로 추출하여 변수에 할당
                // 내부적으로 obj.intValue(); 이렇게 바뀌는 것

    // 개발자가 명시적으로 랩퍼객체를 만들어 값을 담기
    Integer obj2 = new Integer(a); 
    Integer obj3 = a; // auto-boxing : 원시타입의 값을 자동으로 랩퍼객체를 만들어 담는다.
                      // 내부적으로 new Integer(a); 이렇게 해준다. 
  }
}
