/* 문장 : 조건문 if ~ else */
package step04;

public class Test01_3 {

  public static void main(String[] args) {
    int age = 57;
    
    if (age < 8)
      System.out.println("유아");
    else  // if ~ else는 한 문장 
      if (age >=8 && age < 14) 
        System.out.println("어린이");
      else
        if (age >= 14&& age < 19)
          System.out.println("청소년");
        else
          if (age >= 19 && age < 65)
            System.out.println("성인");
          else 
            System.out.println("노인");
    
    // 위와 동일. 코드 보기 좋게 함
    // else if라는 문장은 없다. 오직 if ~ else 문장만 있다. 
    if (age < 8)
      System.out.println("유아");
    else if (age >=8 && age < 14) 
        System.out.println("어린이");
    else if (age >= 14&& age < 19)
        System.out.println("청소년");
    else if (age >= 19 && age < 65)
        System.out.println("성인");
    else 
      System.out.println("노인");

  }

}
