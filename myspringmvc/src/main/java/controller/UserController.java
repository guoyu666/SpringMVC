package controller;

import stereotype.Controller;
import web.bind.annotation.RequestMapping;
import web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String toIndex() {
        return "index";
    }
}
