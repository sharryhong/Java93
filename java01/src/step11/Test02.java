/* 캡슐화(encapsulation): private 옵션
 => 변수 선언이나 메서드 선언 앞에 붙여서 기본 성질을 변경한다는 의미로 이런 키워드를 "변경자(modifier)"라고 부른다. */
package step11;

public class Test02 {

  public static void main(String[] args) {
    Calculator2 c = new Calculator2();
    c.plus(10);
    c.plus(7);
    c.minus(3);
    
    // result는 private모드이기 때문에, 외부에서 접근하는 것이 제한됨
//    c.result = 1000;  // 컴파일 오류!
    
//    System.out.println(c.result); // 값을 꺼낼 수도 없다.
      // 그래서 값을 꺼내주는 도구(메서드)가 필요하다. 
    System.out.println(c.getResult());
  }

}
