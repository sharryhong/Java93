package example;

// 한글 주석. 
public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello");
    
    String level = "mgr";
    switch (level) {
    case "mgr": System.out.println("관리자입니다."); break;
    case "user": System.out.println("일반입니다."); break;
    default: System.out.println("없는 등급입니다.");
    }
  }
}