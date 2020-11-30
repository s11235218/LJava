package serein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serein.mapper.MemberMapper;
import serein.model.Member;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<Member> query(Member member) {
        return memberMapper.selectByCondition(member);
    }
}
