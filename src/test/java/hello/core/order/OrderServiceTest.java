package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    MemberService memberService=new MemberServiceImpl();
//    OrderService orderService=new OrderServiceImpl();


    @BeforeEach
    public  void beforeEach(){
        AppConfig appConfig=new AppConfig();
        memberService= appConfig.memberService();
        orderService= appConfig.orderService();
    }
    MemberService memberService;
    OrderService orderService;

    @Test
    void createOrder(){
        Long memberId=1L;       //long도 사용가능하나 null을 넣을 수 없음음
       Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);
        Order order= orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
