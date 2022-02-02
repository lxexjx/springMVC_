package hello.core.order;

//4. 최종 주문결과를 반환
//주문서비스의 인터페이스
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);   //주문생성시 파라미터를 넘겨 return으로 반환한다.
}
//4. 최종 주문결과를 반환
