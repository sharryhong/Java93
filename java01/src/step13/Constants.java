/* static nested class 문법을 이용하여 상수 값을 계층 구조로 관리한다. */
package step13;

public final class Constants {
  public static final class school {
    public static final int HIGH_SCHOOL = 1;
    public static final int BACHELOR = 2;
    public static final int MASTER = 3;
    public static final int DOCTOR = 4;
  }
  
  public static final class userType {
    public static final int STUDENT = 1;
    public static final int TEACHER = 2;
    public static final int MANAGER = 3;
  }
  
  public static final class lang {
    public static final int JAVA = 1;
    public static final int C = 2;
    public static final int CPP = 3;
    public static final int CS = 4;
    public static final int PYTHON = 5;
    public static final int PHP = 6;
    public static final int JAVASCRIPT = 7;
  }
  
  public static final class work {
    public static final int WORKING = 1;
    public static final int NOT_WORKING = 2;
  }

}
