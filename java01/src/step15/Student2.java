package step15;

public class Student2 {
  
  private String name;
  private int age;
  private SchoolLevel schoolLevel; // SchoolLevel enum상수에 지정한 값만 가능하다.
  
  public String toString() {
    return "Student2 [name=" + name + ", age=" + age + ", schoolLevel=" + schoolLevel + "]";
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public SchoolLevel getSchoolLevel() {
    return schoolLevel;
  }
  public void setSchoolLevel(SchoolLevel schoolLevel) {
    // 최종학력의 값이 무효한지 검사하지 않아도 된다. 
    // 넘어오는 값이 SchoolLevel에 정의된 값이기 때문에 따로 유효여부 검사할 필요가 없다. 
    this.schoolLevel = schoolLevel;
    return;
  }
  
  
}
