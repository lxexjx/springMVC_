package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@MainDiscountPolicy
//@Qualifier("mainDiscountPolicy")
//DiscountPolicy의 구현체
public class RateDiscountPoicy implements DiscountPolicy {

    private int discountPercent=10;

    @Override
    public int discount(Member member, int price) {
       if (member.getGrade()== Grade.VIP){
           return price*discountPercent/100;
       }else{
           return 0;        //ctrl+Shift+t ->자동으로 테스트를 만들어줘
       }
    }
}
