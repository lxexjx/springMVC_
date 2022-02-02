package hello.core.member;

//인터페이스
public interface MemberService {
    void join(Member member);   //가입
    Member findMember(Long memberId);   //찾기
}
