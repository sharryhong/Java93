/* enum 문법 : 상수를 정의할 때 값을 지정할 수 있다.
 * => 이 상수를 DBMS에 저장할 경우, 해당 컬럼이 원하는 값으로 저장해야하기 때문
 */
package step15;

public enum SchoolLevel2 {
  // 다음 각각의 상수는 SchoolLevel2의 객체이다. 
  // 즉, 타입이 SchoolLevel2
  // 각 객체는 상수명과 인덱스 값을 갖고 있다. 
//  HIGH_SCHOOL, // 의미 : SchoolLevel2 HIGH_SCHOOL = new SchoolLevel2(); (기본생성자)
  HIGH_SCHOOL(1), // 의미 : SchoolLevel2 HIGH_SCHOOL = new SchoolLevel2(1);
  BACHELOR(2),
  MASTER(3),
  DOCTOR(4); 
  // 각 강수 객체에 대해 생성자를 호출한다면, 맨 끝 상수에는 세미콜론을 붙여야한다. 
  
  // 생성자를 통해 받은 값을 지정할 인스턴스 변수
  // 상수객체이기 때문에 생성자로부터 한번값을 받으면 바꿀일이 없지만
  // 명확히 보여주기 위해 보통 final을 붙인다. 
  private final int value;
  
  // enum 객체에 값을 지정하고 싶다면, 그 값을 받는 생성자를 선언해야한다. 
  // 값을 여러개 주고 싶다면 파라미터 갯수 늘리면 된다. 
  // 주의! enum생성자는 외부에서 호출할 수 없다. public을 붙일 수 없다. 
  SchoolLevel2(int value) {
    this.value = value;
  }
  
  // 가능하면 인스턴스 변수에 직접 접근하는 것을 막아라!
  // 메서드를 통해 값을 꺼내도록 하라. 
  public int value() {
    return this.value;
  }
}
