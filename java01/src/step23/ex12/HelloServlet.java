package step23.ex12;

import java.io.PrintStream;

@WebServlet(url="/hello")
public class HelloServlet implements Command {
  public void service(PrintStream out) throws Exception {
    out.println("HTTP/1.1 200 OK");
    out.println("Server: BIT Server");
    out.println();
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>hello</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("  <h1>/hello 입니다 :) </h1>");
    out.println("<body>");
    out.println("</html>");
  }
}
