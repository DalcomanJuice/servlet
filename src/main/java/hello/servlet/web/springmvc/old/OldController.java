package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//옛날 컨트롤러는 해당 방식으로 추가 하면 정상적으로 동작했다

@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form"); //view resolver 만들어 줘야 합니다.

        //apprication.properties에 추가해야한다.
        //spring.mvc.view.prefix=/WEB-INF/views/
        //spring.mvc.view.suffix=.jsp
    }
}

//1. 핸들러 매핑에서 컨트롤러를 찾는다.
//  -> 스프링 빈의 이름으로 핸들러를 찾을 수 있는 핸들러 매핑이 필요하다.

//컨트롤러 인터페이스를 실행할 수 있는 핸들러 어댑터를 찾고 실행하자.
// 핸들러 매핑
// -> 0 => 에노테이션으로 등록된 녀석
// -> 1 -> 스프링 빈 이름으로 찾는다.

