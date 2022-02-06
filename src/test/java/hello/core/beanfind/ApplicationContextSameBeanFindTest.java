package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class); //이 SameBeanConfig 컨피그만 가지고 실행

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이사 있으면 중복 오류 발생")
    void findBeanByTtpeDupliate(){
       MemberRepository bean= ac.getBean(MemberRepository.class);
       assertThrows(NoUniqueBeanDefinitionException.class,
               ()-> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 빈이름으로 저장함")
    void findBeanByName(){
        MemberRepository memberRepository=ac.getBean("memberRepository1",MemberRepository.class);   //빈 이름 지정
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회")
    void findAllBeanByType(){
       Map<String, MemberRepository> beansOfType= ac.getBeansOfType(MemberRepository.class);
       for(String key: beansOfType.keySet()){
           System.out.println("key="+key +"value="+ beansOfType.get(key));
       }
        System.out.println("beansOfType"+beansOfType);
       assertThat(beansOfType.size()).isEqualTo(2);     //밑에 memberRepository1,2
    }
    @Configuration
    static class SameBeanConfig{

        @Bean
        public MemberRepository memberRepository1(){
            return  new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return  new MemoryMemberRepository();
        }
    }
}
