package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();    //d여기서 회원을 찾고
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
       int discountPrice= discountPolicy.discount(member,itemPrice);    //discountPolicy는 알아서해~ 결과만 orderservice에 던져줘-> 단일 결과를 잘지킴
        return  new Order(memberId,itemName,itemPrice,discountPrice);
        //->주문생성 요청이 오면 회원정보를 먼저 조회하고 할인정책에 넘겨서 최종 할인된 가격을 받고 최종 생성된 주문을 반환함
    }
}
