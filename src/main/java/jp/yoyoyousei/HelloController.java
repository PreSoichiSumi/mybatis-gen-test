package jp.yoyoyousei;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class HelloController {



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "postvalues", method = RequestMethod.GET)
    public ReceivedValues pos(@RequestParam("str") String str,
                      @RequestParam("num") Integer num) {
        ReceivedValues rv=new ReceivedValues(str, num);
        return rv;
    }
    /*@RequestMapping(value = "postTodo",method = RequestMethod.GET)
    public String postTodo(@RequestParam("title") String title,
                           @RequestParam("content") String content){

    }*/
    
}
