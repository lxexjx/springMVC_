package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {        //psvm

//        AppConfig appConfig=new AppConfig();
//        MemberService memberService= appConfig.memberService();
//        OrderService orderService= appConfig.orderService();
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService=applicationContext.getBean("orderService",OrderService.class);


//        MemberService memberService=new MemberServiceImpl();
//        OrderService orderService=new OrderServiceImpl();

        Long memberId=1L;   //멤버저장
        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);         //memory객체에 넣어놔야 객체에서 찾아 쓸 수 있음

        Order order=orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order="+order);//order.tostring으로 호출됨
        System.out.println("order.calculatePrice="+order.calculatePrice());//tostring으로 호출됨



    }
}
