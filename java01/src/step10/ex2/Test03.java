/* 다형성 - 다형적 변수의 응용 
 * => Student, Teacher, Manager, FreeStudent 객체를 담을 수 있는 배열을 선언하라. */
package step10.ex2;

public class Test03 {

  public static void main(String[] args) {
    // Teacher[] arr 이 배열에는 Teacher만 담을 수 있다. 
//    Teacher[] arr = new Teacher[10];
    
    // 다형적 변수가 빛나는 순간!!
    // 가장 수퍼클래스 배열로 만들면 서브클래스들을 모두 담을 수 있다. 
    Member[] arr = new Member[10];
    arr[0] = new Member();
    arr[1] = new Student();
    arr[2] = new Manager();
    arr[3] = new Teacher();
    arr[4] = new FreeStudent();
  }

}
