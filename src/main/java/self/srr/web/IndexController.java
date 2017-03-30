package self.srr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import self.srr.mapper.FileMapper;
import self.srr.model.Files;

/**
 * Class handling index page request
 *
 * Created by Sharuru on 2017/03/30.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    FileMapper mapper;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
