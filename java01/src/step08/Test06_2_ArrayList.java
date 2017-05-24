/* 컬렉션 클래스 사용 전 - 목록을 다루는 클래스 구현
 * 배열을 이용하여 데이터 목록을 다루는 ArrayList 구현 */
package step08;

class Test06_2_ArrayList {
  // 얘네는 값이 바뀌지 않는 것들 
  // => 값을 조회하는 용도로 사용하고 싶다. 
  // => "상수", 상수변수. : 읽기전용. final 명령을 변수 선언 앞에 붙이고 대문자 변수명
  public static final int DEFAULT_SIZE = 3; // 기본 갯수
  public static final int GROW_SIZE = 3; // 늘어날 갯수
  
  // 얘네는 계속 값이 바뀌는 것들
  // private : 클래스 멤버만이 접근할 수 있게 접근을 제한한다. 
  private Object[] list;
  private int length; // 배열에 값이 몇개들어가있는가
  
  public Test06_2_ArrayList() {
    list = new Object[DEFAULT_SIZE];
  }
  
  public Test06_2_ArrayList(int capacity) {
    if (capacity < DEFAULT_SIZE || capacity > GROW_SIZE) { // 메모리의 효율적 사용을 위해 유효한 값 지정, 처리
      list = new Object[DEFAULT_SIZE];
    } else {
      list = new Object[capacity];
    }
  }
  
  // 맨 끝 빈방에 값 넣기 
  public void add(Object obj) {
//      list[length] = obj; // length자체는 그 다음 값을 가리킨다. index는 0부터 시작, length는 1부터 시작하므로 
//      length++;
    list[length++] = obj; // 위 두 줄을 이렇게 한줄로. length를 넣고 +1
    // 배열이 꽉 찼을 때 배열의 크기를 증가분 만큼 늘린다. 
    if (length == list.length) { 
      increaseList();
    }
  }
  // 값이 들어있는 중간방에 새 값 끼워넣기 
  public void add(int index, Object obj) {
    if (length == list.length) { 
      increaseList();
    }
    
    if (index < 0 || index > length) {
      throw new RuntimeException("배열 인덱스의 범위를 벗어났습니다.");
    }
    
    if (index < length) { // 값을 사이에 새 값을 꼽는다면, 
      // 맨 마지막 값부터 index가 가리키는 방의 값까지 반복하면서 뒤로 한칸씩 미룬다. 
      for (int i = length; i > index; i--) {
        list[i] = list[i - 1];
      }
    }
    list[index] = obj; // 
    length++;
  }

  // ArrayList 클래스 내부에서만 사용할 메서드라면 굳이 공개하지말라! 
  // => private 
  private void increaseList() {
    Object[] newList = new Object[list.length + GROW_SIZE]; // 현재 배열 + 증가분
    for (int i = 0; i < list.length; i++) {
      newList[i] = list[i];
    }
    list = newList; // list에 새배열의 주소를 담는다
  }
  
  // length알 수 있는 메서드 공개
  public int size() {
    return length; // this.lengh인데 this생략
  }
  // 값 꺼내주는 메서드 공개
  public Object get(int index) {
    if (index < 0 || index >= length) { // 예외사항 검사
      throw new RuntimeException("배열 인덱스의 범위를 벗어났습니다."); // 못 꺼낼 때 
    }
    return list[index]; // 이게 이 메서드의 기본
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= length) {
      throw new RuntimeException("배열 인덱스의 범위를 벗어났습니다.");
    }
    
    // 현재 인덱스 값을 지우기 전에 보관
    Object removedObj = list[index];
    
    // 마지막인덱스보다 작을 때까지 하나씩 땡긴다. (그림 그리면서 해보자.)
    if (index < (length - 1)) {
      for (int i = index; i < (length - 1); i++) {
        list[i] = list[i+1];
      }
    }
    length--;
    return removedObj;
  }
  
  public Object set(int index, Object obj) {
    if (index < 0 || index >= length) {
      throw new RuntimeException("배열 인덱스의 범위를 벗어났습니다.");
    }
    
    Object oldObj = list[index];
    list[index] = obj;
    return oldObj;
  }
  
}
