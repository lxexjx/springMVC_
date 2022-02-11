package hello.core.member;

//MemberService 구현체
public class MemberServiceImpl implements MemberService {

    //가입하고 찾기 위해 MemberRepository필요.
    //객체 생성하고 인터페이스에 어떤 게 들어갈지 MemberServiceImpl가 직접 했지
    //private  final MemberRepository memberRepository=new MemoryMemberRepository();  //command+shift+enter

    //객체 생성하고 인터페이스에 어떤 게 들어갈지 MemberServiceImpl가 직접 했지만
    //생성자 주입
    //이제 MemberRepository에만 의존해
    private final MemberRepository memberRepository;   //가입하고 찾기 위해->생성자 만들고

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }   //생성자를 통해서 MemberRepository의 구현체에 뭐가 들어갈지, 추상화에만 의존해해, MemberServiceImpl은 밖에서(Appconfig) 해결

    @Override
    public void join(Member member) {
        memberRepository.save(member);  //-> 다형성에 의해 인터페이스(memberRepository)가 아니라 MemoryMemberRepository의 save()가 호출됨.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

/*Appconfig가 MemoryMemberRepository를 생성하고
MemberServiceImpl생성시에 MemoryMemberRepository를의 참조값을 생성자에 같이 넘겨
그렇게 주입을 받게돼
MemberServiceImpl입장에서는 의존관계를 외부에서 넣어주는 효과-?DI
*/


    //테스트 용동
    public MemberRepository getMemberRepositorym() {
        return memberRepository;
    }
}
