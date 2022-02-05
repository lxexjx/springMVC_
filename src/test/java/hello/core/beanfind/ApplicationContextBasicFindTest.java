package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("빈 이름으로 조회")
    void finBeanByName(){
        MemberService memberService=ac.getBean("memberService",MemberService.class);
//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass() = " + memberService.getClass());
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void finBeanByType(){
        MemberService memberService=ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);  //alt+enter로 static으로 바꿔줌
    }

    @Test
    @DisplayName("구체 타입으로 조회")  //instance로 조회 가능, 구현에 의존 안좋아~
    void finBeanByName2(){      //spring container에  객체가 등록이 돼 있으면 조회 가능
        MemberService memberService=ac.getBean("memberService",MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 안되는 테스트")
    void finBeanByNameX(){      //spring container에  객체가 등록이 돼 있으면 조회 가능
        //ac.getBean("xxxxxx",MemberService.class);
        MemberService xxxxxx=ac.getBean("xxxxxx",MemberService.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxxx",MemberService.class));
    }
}
