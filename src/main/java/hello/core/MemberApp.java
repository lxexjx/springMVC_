package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {    //psvm

        AppConfig appConfig=new AppConfig();
        MemberService memberService =appConfig.memberService();
        //MemberService memberService=new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);  //ctrl+alt+v: 자동완성
        memberService.join(member); //member넣고 회원가입시킴

        Member findMember =memberService.findMember(1L);
        //가입한 멤버랑 찾는 멤버랑 똑같은지 비교 이름 출력해서 비교함
        System.out.println("찾는 new member = " + member.getName());   //soutv단축키
        System.out.println("findMember="+findMember.getName());
    }
}
