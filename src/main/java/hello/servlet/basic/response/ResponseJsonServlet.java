package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//나중엔 더 간단해진다.
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json"); //json은 컨텐츠 타입을 이걸로 바꿔야 한다.
        resp.setCharacterEncoding("utf-8"); //기본 utf-8로 세팅되어 있어서 별 의미 없다.

        HelloData dto = new HelloData();
        dto.setUsername("kim");
        dto.setAge(20);

        String result = objectMapper.writeValueAsString(dto);
        resp.getWriter().write(result);
    }
}
