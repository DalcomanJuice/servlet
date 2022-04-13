package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    //이걸로 무줘건 호출해 줄거야. method = RequestMethod.GET get으로만 받겠다. 제약을 거는 설계.
    //이렇게 쓰면 너무 길다
    //@RequestMapping(value = "/new-form", method = RequestMethod.GET)

    @GetMapping("/new-form")
    public String newForm(){
        return "new-form";
    }
    //에노테이션 기반의 컨트롤러는 유연하게 설계되서 문자를 반환해도 된다.
    //애가 뷰 이름인지 알고 그래도 작동한다.

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model){
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }

    //@RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                       @RequestParam("age") int age,
                       Model model){

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }
}
