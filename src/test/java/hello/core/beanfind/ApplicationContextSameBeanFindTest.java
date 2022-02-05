package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig); //이 SameBeanConfig 컨피그만 가지고 실행

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이사 있으면 중복 오류 발생")
    void findBeanByTtpeDupliate(){
       MemberRepository bean= ac.getBean(MemberRepository.class);
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
