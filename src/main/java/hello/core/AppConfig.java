package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//application전체를 설정하고 구성하는 자바, 구현 객체를 생성!!
public class AppConfig {
    public MemberService memberService(){       //MemberService 구현객체가 생성되고
        return  new MemberServiceImpl(new MemoryMemberRepository());
        //생성자 주입!!!
    }
    public  OrderService orderService(){
        return  new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
    }
}
