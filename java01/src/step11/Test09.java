/* 캡슐화 : 필드와 프로퍼티
 */
package step11;

public class Test09 { 
  
  static class Student {
    public static final int HIGH_SCHOOL = 1;
    public static final int BACHELOR = 2;
    public static final int MASTER = 3;
    public static final int DOCTOR = 4;
    
    // 필드 선언 : 변수. 보통 접근하지 못하게 막는다.(private)
    private String name;
    private int age;
    private int level;
    
    // 프로퍼티 선언 : setter, getter 메서드
    // => 필드의 값을 넣거나 꺼내는 메서드
    // => setXxx()/getXxx() 이름으로 메서드를 정의한다. 
    // setXxx() : 셋터(setter), getXxx() : 겟터(getter) 라고 부른다.
    // 보통 공개한다.(public)
    
    // 프로퍼티 이름 
    // => setter/getter 메서드 이름에서 set/get을 제외한다. 
    // => 나머지 이름에서 첫 알파벳을 소문자로 만든다. 
    
    // 실무에서는 보통 프로퍼티명과 필드명을 같게한다. 
    // 필드명 : name 
    // 이 메서드의 프로퍼티명 : fullName
    public void setFullName(String fullName) {
      name = fullName; // 로컬변수와 이름이 다르므로 this생략 
    }
    public String getFullName() {
      return name;
    }
    // 지금처럼 setter, getter프로퍼티가 모두 있다 : read/write 프로퍼티라 한다. 
    // set프로퍼티만 있다. : 
    // get프로퍼티만 있다. : 
    
    // 이 메서드의 프로퍼티명 : age
    public void setAge(int age) {
      if (age > 5 && age < 100) {
        this.age = age;
      }
      throw new RuntimeException("나이는 6 ~ 99살까지 가능합니다.");
    }
    public int getAge() {
      return age;
    }
    
    // 이 메서드의 프로퍼티명 : schoolLevel
    public void setSchoolLevel(int level) {
      if (level >= 1 && level <= 4) {
        this.level = level;
      }
      throw new RuntimeException("학위 정보는 1~4까지 가능합니다.");
    }
    public int getSchoolLevel() {
      return level;
    }
  }
  
  public static void main(String[] args) {
    Student s = new Student();
//    s.name = "홍길동";// 예전엔 직접 줬다면
    s.setFullName("홍길동");
    s.setAge(20);
    s.setSchoolLevel(Student.DOCTOR); // 4라고 해도 되지만 명시적이지 않다. 지금처럼 상수를 넣으면 이해가 쉽다.
  }

}
