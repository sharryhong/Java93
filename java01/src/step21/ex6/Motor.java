package step21.ex6;

// 인스턴스를 만들어 직접 쓸 일 없으면 추상클래스로
public abstract class Motor {
  float ampere; // 암페어
  int rpm;      // 회전수
  float watt;   // 와트 
  
  public Motor() {}
  
  public Motor(float ampere, int rpm, float watt) {
    this.ampere = ampere;
    this.rpm = rpm;
    this.watt = watt;
  }
}
