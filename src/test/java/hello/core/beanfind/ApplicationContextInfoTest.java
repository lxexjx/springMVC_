package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//진짜 말 그대로 빈 출력하기
public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    //ac.getBeanDefinitionNames()스프링에 등록되 빈 이름 조회
    @Test
    @DisplayName("모든 빈출력하기")
   public void findAllBean(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for(String beanDefinitionName: beanDefinitionNames){    //iter + tab
            Object bean=ac.getBean(beanDefinitionName); //bean꺼내
            System.out.println("name = " + beanDefinitionName+"objecr="+bean);   //soutv:변수명 soutm:메서드명

        }
    }

    @Test
    @DisplayName("애플리케이션 빈출력하기")    //
    void findApplicationBean(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for(String beanDefinitionName: beanDefinitionNames){
            BeanDefinition beanDefinition =ac.getBeanDefinition(beanDefinitionName);   //bean에 관한 정보들 꺼네기

            //ROLE_INFRASTRUCTURE:스프링이 내부에서 사용하는 빈
            //ROLE_APPLICATION:직접 등록한 애플리케이션 빈,spring내부가 아니라 내가 application 사용하려고 등록한 빈->5개만 출력됨
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION) {
                Object bean=ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName+"objecr="+bean);
            }
        }
    }
}
