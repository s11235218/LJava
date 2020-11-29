package serein.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serein.model.Award;
import serein.service.RecordService;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;
}
