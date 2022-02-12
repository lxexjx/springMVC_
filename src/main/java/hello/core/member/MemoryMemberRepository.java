package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component

//MemberRepository 구현체
public class MemoryMemberRepository implements  MemberRepository{

    //저장소 만들기
   private  static Map<Long,Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    //저장소에서 가져와서 id찾기
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
