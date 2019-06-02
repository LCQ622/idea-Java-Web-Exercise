package cn.mcandroid.controller;

import cn.mcandroid.pojo.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {

    @Autowired
    private Stu stu;
    @RequestMapping(value = "/t1",method = RequestMethod.GET)
    public ModelAndView t1(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("t1");
        mv.addObject("stu",stu);
        System.out.println(stu);
        return  mv;
    }
}
