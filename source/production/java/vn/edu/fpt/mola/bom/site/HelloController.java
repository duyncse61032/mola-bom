package vn.edu.fpt.mola.bom.site;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.edu.fpt.mola.bom.config.annotation.WebController;


@WebController
public class HelloController
{
    private GreetingService greetingService;

    @ResponseBody
    @RequestMapping("/")
    public String helloWorld()
    {
        return "Hello, World!";
    }

    @ResponseBody
    @RequestMapping(value = "/", params = { "name" })
    public String helloName(@RequestParam("name") String name)
    {
        return this.greetingService.getGreeting(name);
    }

    @Inject
    public void setGreetingService(GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }
}
