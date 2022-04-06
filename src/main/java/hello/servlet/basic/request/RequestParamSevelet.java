package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
    1. 파라미터 전송 가능
    http://localhost:8080/request-param?username=hello&age=20
 **/
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamSevelet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");
        req.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName + "=" + req.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회] - start"); //중복이 아닐경우 사용한다. -> 중복 파라메터일 경우 제일 첫번째 녀석을 반환한다.
        String username = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end");
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회] - start");
        String[] usernames = req.getParameterValues("username");
        for(String name : usernames)
            System.out.println("username = " + name);
        System.out.println("[이름이 같은 복수 파라미터 조회] - end");
        System.out.println();

        resp.getWriter().write("ok");

        req.getParameterNames();
    }
}
