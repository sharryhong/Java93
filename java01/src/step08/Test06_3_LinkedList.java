package step08;

class Test06_3_LinkedList {
  // 노트 그림을 보자. 버킷은 값과 다름 버킷의 주소를 보관한다. 
  class Bucket {
    Object value;
    Bucket next;
  }
  
  Bucket start;
  Bucket end;
  private int length;
  
  public Test06_3_LinkedList() {
    start = new Bucket(); // 기본생성자 : 빈 버킷을 하나만든다.
    end = start; // 시작 주소는 끝주소와 같다. 시작과 끝 버킷의 위치정보 설정
  }
  
  // 맨 끝 버킷에 값 넣기 
  public void add(Object obj) {
    end.value = obj;
    
    // 빈 버킷 만들기 
    Bucket temp = new Bucket();
    end.next = temp; // end의 next에 주소넣기. (다음 버킷 가리킴)
    end = temp;
    
    length++;
  }
  
  public int size() {
    return length;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= length) {
      throw new RuntimeException("배열 인덱스의 범위를 벗어났습니다."); 
    }
    
    Bucket cursor = start;
    
    for (int i = 0; i < index; i++) {
      cursor = cursor.next; // 현재 cursor의 next에 담겨있는 주소(다음 버킷)
    }
    return cursor.value;
  }
  
  public void add(int index, Object obj) {    
    if (index < 0 || index >= length) { 
      throw new RuntimeException("배열 인덱스의 범위를 벗어났습니다.");
    }
    
    // 새 버킷을 준비하고, 값을 보관한다. 
    Bucket temp = new Bucket(); 
    temp.value = obj;
    length++;
    
 // index가 0일때
    if (index == 0) { 
      temp.next = start;
      start = temp;
      return;
    }
    
    // index가 0이 아닐땐 start가 변하지 않는다. 
    Bucket cursor = start; // cursor는 항상 start에서 시작한다. 
    for (int i = 1; i < index; i++) {
      cursor = cursor.next;  // cursor로 찾아가서 next값을 여기에 놓고. 이 값을 cursor에 넣는다.
                            // 이 작업을 add하고자하는 위치 전까지 반복하여 찾아간다.
    }
    temp.next = cursor.next;
    cursor.next = temp;
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= length) {
      throw new RuntimeException("배열 인덱스의 범위를 벗어났습니다.");
    }
    
    length--;
    
    if (index == 0) { // 0일 경우 
      Bucket temp = start; // 지우기 전에 보관
      start = start.next;
      return temp;
    }
    
    Bucket cursor = start;
    
    // 0아닌 경우. 인덱스가 가리키는 버킷객체의 바로 전 주소를 알아내기 
    for (int i = 1; i < index; i++) {
      cursor = cursor.next;
    }

    Bucket removedObj = cursor.next; // cursor의 next에 있는 주소가 삭제될 객체이다.
    cursor.next = cursor.next.next; // 삭제될 next에 있는 주소를 넣음으로서 연결시킨다.
    return removedObj.value; // remove되는 버킷의 value 리턴
  }
  
  public Object set(int index, Object obj) {
    if (index < 0 || index >= length) {
      throw new RuntimeException("배열 인덱스의 범위를 벗어났습니다.");
    }
    
    Bucket cursor = start;
    
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    Object oldValue = cursor.value;
    cursor.value = obj;
    
    return oldValue;
  }
}
