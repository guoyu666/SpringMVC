package usermgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import usermgt.bean.User;
import usermgt.dao.UserDao;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value ="/user",method = RequestMethod.GET)
    public String list(Model model){
        // 查询数据库，获取用户列表List集合
        List<User> users = userDao.selectAll();
        // 将用户列表存储到request域当中
        model.addAttribute("users",users);
        // 转发到视图
        return "user_list";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String save(User user){
        // 调用userDao保存用户信息
        userDao.insert(user);
        // 重定向到用户页面(重新让浏览器发送一次全新的数据，去请求列表页面)
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/{id}")
    public String detail(@PathVariable("id") Long id, Model model){
        // 通过id查找用户信息
        User user = userDao.selectById(id);
        // 将用户信息存储到request域
        model.addAttribute("user",user);
        // 转发到视图
        return "user_edit";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String modify(User user){
        // 修改用户信息
        userDao.update(user);
        // 重定向到列表页面
        return "redirect:/user";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String del(@PathVariable("id") Long id){
        // 调用dao删除用户
        userDao.deleteById(id);
        // 重定向到列表
        return "redirect:/user";
    }
}
