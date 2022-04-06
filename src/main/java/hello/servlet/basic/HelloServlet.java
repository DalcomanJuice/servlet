package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

//서블릿 이름 urlpattern은 겹치면 안된다.
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    //ctrl + o 로 생성. 자물쇠 걸려있는 부분이 protected 함수이다.
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        
        System.out.println("HelloServlet.service"); //soutm <- 자동으로 println 생성 -> localhost:8080/hello <- 출력됩니다.
        System.out.println("request = " + request); //soutv
        System.out.println("response = " + response); //soutv
        System.out.println("request = " + request + ", response = " + response);

        //? 뒤는 쿼리 파라미터 이다. -> 네임을 알 수 있다. 파라메터 가져오기 쉽다.
        String name = request.getParameter("username");
        System.out.println("username = " + name);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); //기본 utf-8을 써야 한다.
        response.getWriter().write("hello" + name); //message body에 들어감

    }
}

