package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    //memberService.join이거 사용하기 위해
//    MemberService memberService=new MemberServiceImpl();

    MemberService memberService;
    @BeforeEach
    public  void beforeEach(){
        AppConfig appConfig=new AppConfig();
        memberService= appConfig.memberService();
    }
    @Test
    void join(){
        //given ~주어졌을때
        Member member=new Member(1L,"membera",Grade.VIP);
        //when ~이렇게 했을 때
        memberService.join(member);
        Member findMember=memberService.findMember(1L); //찾아서 then에서 검증
        //then ~이렇게 된다  join한거랑==찾은거랑 같은지
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
