package com.offcn.springboot.controller;

import com.offcn.springboot.bean.Employee;
import com.offcn.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class EmpmoyeeController{
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/")
    public String jump(){
    return "login";
    }
    @PostMapping("login")
    /*登录方法*/
    public String login(Integer eid,String ename,Model model){
        Employee employee = employeeService.login(eid,ename);
        if(employee != null){
            return "redirect:/showInfo";
        }else{
            model.addAttribute("msg","登录异常");
            return "login";
        }

    }
    /*展示所有用户的方法*/
    @GetMapping("showInfo")
    public String showInfo(Model model, @RequestParam(name = "cp",defaultValue = "0") Integer currentPage){
        Page<Employee> pages = employeeService.showInfo(currentPage);
        model.addAttribute("pageInfo",pages);
        model.addAttribute("list",pages.getContent());
        return "emp/show";

    }
    @GetMapping("deleteInfo")
    public  String deleteInfo(Integer eid) {
            boolean flag = employeeService.deleteInfo(eid);
            return "redirect:/showInfo";
    }
}
