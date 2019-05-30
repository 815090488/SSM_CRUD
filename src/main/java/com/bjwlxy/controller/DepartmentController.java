package com.bjwlxy.controller;

import com.bjwlxy.pojo.Department;
import com.bjwlxy.pojo.Msg;
import com.bjwlxy.service.DepartmentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentServer departmentServer;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
       List<Department> list= departmentServer.getDepts();
       return Msg.success().add("depts",list);
    }
}
