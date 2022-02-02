package hello.core.member;

//인터페이스
public interface MemberRepository {
    void save(Member member);   //저장 기능
    Member findById(Long memberId); //찾는 기능
}
