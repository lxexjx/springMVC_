package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {    //단축키psvm

//        AppConfig appConfig=new AppConfig();
//        MemberService memberService =appConfig.memberService();->직접 찾았다면. memberService여기에 memberServiceImpl있어서 appconfig에서 memberServiceImpl가 객체를 생성해서  주입해

        /*스프링으로 전환하기!!! 스프링은 ApplicationContext로 시작, 스프링 컨테이너
        springcontainer:config에있는 설정정보로 ApplicationContext객체(@Bean)를 관리, 컨테이너로 찾아와
        =>AppConfig에 있는 환경설정 정보를 가지고  스프링이 안에 있는 @Bean을 스프링컨테이너에 객체 생성한거를 다 넣어놓고 관리애        * */
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class); // memberService이 객체를 찾을 거야!(이름,타입:MemberService.class)근데 스프링 컨테이너를 사용해서 찾아와

        //회원가입
        //MemberService memberService=new MemberServiceImpl(); 기존에 직접 생성했다면
        Member member = new Member(1L, "memberA", Grade.VIP);  //ctrl+alt+v: 자동완성
        memberService.join(member); //member넣고 회원가입시킴


        //회원가입이 됐는 지,가입한 멤버==찾는 멤버랑 똑같은지 비교 이름 출력해서 비교함
        Member findMember =memberService.findMember(1L);
        System.out.println("찾는 new member = " + member.getName());   //soutv단축키
        System.out.println("findMember="+findMember.getName());
    }
}
