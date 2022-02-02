package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPoicy;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 실제 실행되는 객체들은 역할만 수행하고 어떤 구현체가 인터페이스에 할당 될지는 Appconfig가 해
   Appconfig는 동작 방식을 설정하기 위해 구현객체를 생성하고 연결하는 별도의 설정 클래스
* */

/*필요한 구현 객체 생성
* */
@Configuration  //application의 설정정보를 담당
//application전체를 설정하고 구성하는 자바, 구현 객체를 생성!!
public class AppConfig {
    
    //생성자 주입!!!
    //리팩터링: 역할이 드러남. 메서드 명으로 . 역할의 구현이 나타남.

    //객체 생성하고 인터페이스에 어떤 게 들어갈지 MemberServiceImpl가 직접 했지만 이젠 Appconfug가 직접 환경설정을 해
    @Bean   //각 메서드에 bean이라 작성->spring container에 등록
    public MemberService memberService(){//MemberService 구현체인 객체가 생성되고
        return  new MemberServiceImpl(memberRepository()); //MemoryMemberRepository가 들어와
    }
    @Bean   //MemoryMemberRepository역할
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean   //orderService역할
    public  OrderService orderService(){
        return  new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean   //discountPolicy역할, 위에 discountPolicy()참고해~
    public DiscountPolicy discountPolicy(){
        //return  new FixDiscountPolicy();
        return new RateDiscountPoicy();
    }
}
