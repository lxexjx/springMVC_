package hello.core.discount;

import hello.core.member.Member;

//할인정책 인터페이스
public interface DiscountPolicy {

    //return:할인대상금액->호출하고 나면 결과로 얼마를 할인금액을 리턴
    int discount(Member member,int price);
}
