package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requsetBodyJsonSevlet", urlPatterns = "/request-body-json")
public class RequsetBodyJsonServelet extends HttpServlet {

    //jackson 라이브러를 통해서 json 컨버팅 한다.
    private ObjectMapper objectMapper = new ObjectMapper();



    @Override //Spring MVC를 사용하게 되면 나중에는 HelloData helloData 도 모두 들어간다. Spring MVC로 가면 다르게 쓴다. 나중에 서블릿 안씀.
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); //요즘은 기본 utf 8 사용

        System.out.println("messageBody = " + messageBody);

        //이걸 통해서 컨버팅 한다.
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println("helloData.username = " + helloData.getUsername());
        System.out.println("helloData.age = " + helloData.getAge());

        resp.getWriter().write("ok");
    }
}
