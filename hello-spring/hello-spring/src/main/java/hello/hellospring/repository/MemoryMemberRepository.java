package hello.hellospring.repository;

import hello.hellospring.domain.Members;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{ //alt+enter누르면 implements method 다 들어와

    private static final Map<Long, Members> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Members save(Members member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Members> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //null을 감싸서 반환. 요즘트렌트
    }

    @Override
    public Optional<Members> findByName(String name) {
        return store.values().stream()
                .filter(members -> members.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Members> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}