package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //private  final MemberRepository memberRepository=new MemoryMemberRepository();  //command+shift+enter
    private  final MemberRepository memberRepository;   //->생성자 만들고
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }   //생성자를 통해서 MemberRepository의 구현체에 뭐가 들어갈지, 추상화에만 의존해해, MemberServiceImpl은 밖에서 해결
    @Override
    public void join(Member member) {
        memberRepository.save(member);  //-> 다형성에 의해 인터페이스가 아니라 MemoryMemberRepository의 save()가 호출됨.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
