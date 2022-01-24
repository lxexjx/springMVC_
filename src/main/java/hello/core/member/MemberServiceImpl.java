package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private  final MemberRepository memberRepository=new MemoryMemberRepository();  //command+shift+enter

    //
    @Override
    public void join(Member member) {
        memberRepository.save(member);  //-> 다형성에 의해 인터페이스가 아니라 MemoryMemberRepository의 save()가 호출됨.
    }
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
