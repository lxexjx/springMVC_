package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {        //psvm

        AppConfig appConfig=new AppConfig();
        MemberService memberService= appConfig.memberService();
        OrderService orderService= appConfig.orderService();

//        MemberService memberService=new MemberServiceImpl();
//        OrderService orderService=new OrderServiceImpl();

        Long memberId=1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);         //memory객체에 넣어놓고

        Order order=orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order="+order);//tostring으로 호출됨
        System.out.println("order.calculatePrice="+order.calculatePrice());//tostring으로 호출됨



    }
}
