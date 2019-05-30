package com.bjwlxy.service;

import com.bjwlxy.mapper.DepartmentMapper;
import com.bjwlxy.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServer {

    @Autowired
    private DepartmentMapper departmentMapper;
    public List<Department> getDepts() {

        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}
