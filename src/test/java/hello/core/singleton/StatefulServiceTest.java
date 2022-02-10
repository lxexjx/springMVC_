package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulSErviceSingleton(){
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1=ac.getBean(StatefulService.class);
        StatefulService statefulService2=ac.getBean(StatefulService.class);

        //TreadA: A사용자가 10000원 주문
        //statefulService1.order("userA",10000);
        int userAPrice=statefulService1.order("userA",10000);   //지역변수

        //TteadB: B사용자가 20000원 주문
        //statefulService2.order("userB",20000);
        int userBPrice=statefulService1.order("userA",20000);   //지역변수

        //TreadA: A사용자가 주문 금액 조회
        //int price=statefulService1.getPrice();
        //System.out.println("price"+price);  //->사용자B가 바꿔버려서 2만원으로 나와
        System.out.println("price"+userAPrice);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}