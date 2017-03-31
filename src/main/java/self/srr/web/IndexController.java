package self.srr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Class handling index page request
 * <p>
 * Created by Sharuru on 2017/03/30.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * Requesting index page
     *
     * @return index template
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
