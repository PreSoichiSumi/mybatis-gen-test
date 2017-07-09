package jp.yoyoyousei;

import com.fasterxml.jackson.databind.ObjectMapper;
import jp.yoyoyousei.mybatis.gen.Todo;
import jp.yoyoyousei.mybatis.gen.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class HelloController {

    TodoMapper todoMapper;

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
    @RequestMapping(value = "postTodo",method = RequestMethod.GET)
    public String postTodo(@RequestParam("title") String title,
                           @RequestParam("content") String content) throws Exception {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setContent(content);
        todo.setId(5);
        todoMapper.insertSelective(todo);
        ObjectMapper om=new ObjectMapper();
        return om.writeValueAsString(todo);
    }
    
}
