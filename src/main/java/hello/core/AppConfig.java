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


@Configuration  //application의 설정정보를 담당
//application전체를 설정하고 구성하는 자바, 구현 객체를 생성!!
public class AppConfig {
    
    //생성자 주입!!!
    //리팩터링: 역할이 드러남. 역할의 구현이 나타남.

    @Bean   //각 메서드에 bean이라 작성->spring container에 등록
    public MemberService memberService(){       //MemberService 구현객체가 생성되고
        return  new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public  OrderService orderService(){
        return  new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        //return  new FixDiscountPolicy();
        return new RateDiscountPoicy();
    }
}
