package step21.ex7;

public class Test02 {

  public static void main(String[] args) {
    // 추상클래스의 레퍼런스 변수에는 그 서브클래스의 인스턴스를 저장할 수 있다.
    B obj;
//    obj = new C(); // Error! C는 추상클래스이기 때문에 인스턴스 생성 불가
    obj = new D();
    
    obj.m2(); // 실제 클래스인 D의 메서드 m2() 호출
  }

}
