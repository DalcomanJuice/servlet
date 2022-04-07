package hello.servlet.web.serveletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);//sevelet 에서 jsp 호출 <- 서버 내부에서 다시 호출합니다.
                                        //WEB-INF 경로에 있는 html 파일을들 직접 호출 불가능 하다. 무줘건 서버를 한번 거쳐서 호출이 가능해 집니다.
                                        //rediect / forward : 웹부라우저에서 서버로 여러번 호출이 가능하다.
                                        //forward : 한번 호출하고 서버 내부에서 일어나느 호출이기 떄문에 클라이언트에서 인지 못함.
    }
}
