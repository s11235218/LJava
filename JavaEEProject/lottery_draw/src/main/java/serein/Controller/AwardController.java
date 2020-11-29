package serein.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serein.model.Award;
import serein.service.AwardService;

@RestController
@RequestMapping("/award")
public class AwardController {

    @Autowired
    private AwardService awardService;
}
