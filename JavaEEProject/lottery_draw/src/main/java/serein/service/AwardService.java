package serein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serein.mapper.AwardMapper;
import serein.model.Award;

import java.util.List;

@Service
public class AwardService {

    @Autowired
    private AwardMapper awardMapper;

    public List<Award> query(Award award) {
        return awardMapper.query(award);

    }
}
