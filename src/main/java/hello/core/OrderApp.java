package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {        //psvm
        MemberService memberService=new MemberServiceImpl();
        OrderService orderService=new OrderServiceImpl();

        Long memberId=1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);
    }
}
