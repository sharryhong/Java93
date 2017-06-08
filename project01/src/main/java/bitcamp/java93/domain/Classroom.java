/* 역할 : 테이블의 값을 보관할 때 사용할 클래스 */
package bitcamp.java93.domain;

public class Classroom {
  int no;
  String name;
  
  @Override
  public String toString() {
    return "Classroom [no=" + no + ", name=" + name + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

}
