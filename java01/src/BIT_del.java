import java.io.File;

public class BIT_del {

  public static void main(String[] args) throws Exception {
    
    File f = new File("./");
    if (args[0].equals("-R")) {
      findFile(f, args[1], 0);      
    } else {
      findFile(f, args[0], 0);
    }

  }
  public static void findFile(File dir, String name, int level) throws Exception {
    File[] files = dir.listFiles();

    for (File file : files) {
      if (file.isFile()) {
        if (name.charAt(0) == 'x' && file.getName().endsWith(name.substring(1))) {
          System.out.println(file.getCanonicalPath());
          file.delete();
        } else if (file.getName().equals(name)) {
          System.out.println(file.getCanonicalPath());
          file.delete();
        }
      }
      if (file.isDirectory()) findFile(file, name, level + 1);
    }
  }

}
