package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPoicyTest {

    RateDiscountPoicy discountPoicy=new RateDiscountPoicy();

    @Test
    @DisplayName("VIP는10%할인이 적용됨")  //한글로 쓸 수 있음

    void vip_o(){
        //given
        Member member= new Member(1L,"memberVIP", Grade.VIP);
        //when
        int discount=discountPoicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(1000);    //alt+emter로 static method로 만들어주는게 좋아=>Assertions.assertThat(discount).isEqualTo(1000);가
    }

    @Test
    @DisplayName("VIP가 아니면 할이니 적용 안됨")

    void vip_x(){
        //given
        Member member= new Member(2L,"memberBASIC", Grade.BASIC);
        //when
        int discount=discountPoicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}