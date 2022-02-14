package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

//@Qualifier("fixDiscountPolicy")
//DiscountPolicy의 구현체
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount=1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade()== Grade.VIP){ //enum은 ==사용
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
