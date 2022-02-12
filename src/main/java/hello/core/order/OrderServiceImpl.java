package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPoicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

//OrderService의 구현체
public class OrderServiceImpl implements OrderService {
    /*
    OrderServiceImpl이 직접 객체를 생성하고 구체적인 선택도함
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); 고정할인금액에서
    private final DiscountPolicy discountPolicy=new RateDiscountPoicy();    새로운 할인정책으로 RateDiscountPoicy로 바꾸면
    클라이언트인 OrderServiceImpl를 고쳐야됨
    추상(인터페이스):DiscountPolicy,구현(구체):FixDiscountPolicy,RateDiscountPoicy->OCP,DIP위반
    OrderServiceImpl이 DiscountPolicy에만 의존하도록 바꾸려면 OrderServiceImpl에 DiscountPolicy의 구현객체를 대신 생성하고 주입!!
    */


//    private final MemberRepository memberRepository = new MemoryMemberRepository();    //여기서 회원을 찾고
//    private  DiscountPolicy discountPolicy; //이렇게 바꿔주면 인터페이스에만 의존해 추상화 인터페이스에만 의존해- but! OerderService에서 nullpoint예외남(아무것도 할당된게 없어)DIP못지킴

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //주문 생성 요청이 오면 회원정보를 조회하고, 할인정책에 회원을 넘겨
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);    //멤버찾고
        int discountPrice = discountPolicy.discount(member, itemPrice);    //discountPolicy는 알아서해~ 결과만 orderService에 던져줘-> 단일 체계 결과를 잘지킴
        return new Order(memberId, itemName, itemPrice, discountPrice);   //최종생성된 주문을 반화함
        //->주문생성 요청이 오면 회원정보를 먼저 조회하고 할인정책에 넘겨서 최종 할인된 가격을 받고 최종 생성된 주문을 반환함
    }

/*OrderServiceImpl은 이제 FixDiscountPolicy이런거 의존안해.순수 인터페이스(discountPolicy)에만 의존
    생성자를 통해 어떤 구현 인스턴스가 들어올지 전혀 몰라,Appconfig에서 결정
    OrderServiceImpl에 이제 FixDiscountPolicy,RateDiscountPoicy객체의 읜존관계가 주입됨
* */



}