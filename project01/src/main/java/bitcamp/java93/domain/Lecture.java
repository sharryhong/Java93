/* 역할 : memb테이블의 값을 보관할 때 사용할 클래스
 */
package bitcamp.java93.domain;

public class Lecture {
  int no;
  int crmno;
  int mrno;
  String title;
  String description;
  String startDate;
  String endDate;
  int quantity;
  int price;
  int thrs;
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getCrmno() {
    return crmno;
  }
  public void setCrmno(int crmno) {
    this.crmno = crmno;
  }
  public int getMrno() {
    return mrno;
  }
  public void setMrno(int mrno) {
    this.mrno = mrno;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getStartDate() {
    return startDate;
  }
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }
  public String getEndDate() {
    return endDate;
  }
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getThrs() {
    return thrs;
  }
  public void setThrs(int thrs) {
    this.thrs = thrs;
  }
  @Override
  public String toString() {
    return "Lecture [no=" + no + ", crmno=" + crmno + ", mrno=" + mrno + ", title=" + title + ", description="
        + description + ", startDate=" + startDate + ", endDate=" + endDate + ", quantity=" + quantity + ", price="
        + price + ", thrs=" + thrs + "]";
  }
  
}
