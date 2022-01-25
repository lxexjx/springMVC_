package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);   //주문생성시 파라미터를 넘겨 return으로 반환한다.
}
