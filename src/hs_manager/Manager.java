/* 역할 : 테이블의 값을 보관할 때 사용할 클래스
 */
package hs_manager;

public class Manager extends step03.Member {
  int mrno;
  String posi;
  String fax;
  String path;
  
  @Override
  public String toString() {
    return "Manager [mrno=" + mrno + ", posi=" + posi + ", fax=" + fax + ", path=" + path + "]";
  }
  public int getMrno() {
    return mrno;
  }
  public void setMrno(int mrno) {
    this.mrno = mrno;
  }
  public String getPosi() {
    return posi;
  }
  public void setPosi(String posi) {
    this.posi = posi;
  }
  public String getFax() {
    return fax;
  }
  public void setFax(String fax) {
    this.fax = fax;
  }
  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
  }
  
  
}
