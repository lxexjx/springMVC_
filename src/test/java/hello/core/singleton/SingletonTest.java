package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    void pureContainer(){
        AppConfig appConfig=new AppConfig();

        //1.조회:호출 할 때마다 객체를 생성
        MemberService memberService1= appConfig.memberService();

        //2.조회:호출 할 때마다 객체를 생성
        MemberService memberService2= appConfig.memberService();
        MemberService memberService3= appConfig.memberService();

        System.out.println("memberService1="+memberService1);
        System.out.println("memberService2="+memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }
}
