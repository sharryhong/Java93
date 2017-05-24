package step09.ex2;

// extends BasicCalculator : BasicCalculator의 코드를 재사용할 것이고,
// 거기에 기능을 추가할 것이다. 
public class AdvancedCalculator extends BasicCalculator {
  
  // 새 곱하기 기능 추가
  void multiple(int value) {
    this.result *= value;
  }

}
