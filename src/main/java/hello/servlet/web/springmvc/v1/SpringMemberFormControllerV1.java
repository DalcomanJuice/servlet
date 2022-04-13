package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//스프링이 자동으로 스프링 빈에 등록된다.

//@Component  //spring 빈으로 들어감
//@RequestMapping //request Mapping이 이녀석을 찾아낸다.
@Controller //<- controller 는 한개만 있어도 된다.
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }



}
