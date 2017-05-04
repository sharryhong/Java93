/* 사용자 정의 데이터 타입 : 배열 */
package step02;

public class Test13 {

  public static void main(String[] args) {
    
    // 1)
    class Student {
      String name;
      byte[] scores;
      short total;
      float aver;
    }
    
    // 1) Student의 레퍼런스를 3개 만든다. 
    Student[] arr1 = new Student[3];
    
    // 인스턴스 배열을 만드는 문법은 없다. 즉, 인스턴스 배열을 만들 수 없다. 
    // 2) 
    // 레퍼런스 변수가 3개이며, 주소가 들어간다. 
    arr1[0] = new Student(); 
    arr1[1] = new Student();
    arr1[2] = new Student();
    
    // 3)  
    arr1[0].name = "홍길동";
    arr1[0].scores = new byte[3];
    arr1[0].scores[0] = 100;
    arr1[0].scores[1] = 100;
    arr1[0].scores[2] = 100;
    arr1[0].total = (short)(arr1[0].scores[0] + arr1[0].scores[1] + arr1[0].scores[2]);
    arr1[0].aver = arr1[0].total / 3f;
    
    arr1[1].name = "임꺽정";
    arr1[1].scores = new byte[]{90, 90, 90};
    arr1[1].total = (short)(arr1[1].scores[0] + arr1[1].scores[1] + arr1[1].scores[2]);
    arr1[1].aver = arr1[1].total / 3f;
    
    arr1[2].name = "유관순";
    arr1[2].scores = new byte[]{80, 80, 80};
    arr1[2].total = (short)(arr1[2].scores[0] + arr1[2].scores[1] + arr1[2].scores[2]);
    arr1[2].aver = arr1[2].total / 3f;
    
    // 배열을 쓰면 좋은점? 반복문을 사용할 수 있다. 
    for (int i = 0; i < arr1.length; i++) {
      System.out.printf("%s, %d, %d, %d, %d, %f\n", arr1[i].name, arr1[i].scores[0], arr1[i].scores[1], arr1[i].scores[2], arr1[i].total, arr1[i].aver);      
    }

  }

}
