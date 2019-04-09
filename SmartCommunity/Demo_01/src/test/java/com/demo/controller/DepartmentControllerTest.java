package com.demo.controller;

import com.demo.Application;
import com.demo.service.IDepartmentService;
import com.demo.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DepartmentControllerTest {
    @Autowired
    private IDepartmentService departmentService;
    @Resource
    private IEmployeeService employeeService;
    @Test
    public void get() {
        System.out.println(departmentService.selectOne(1l));
    }

    @Test
    public void list() {
        System.out.println(employeeService.queryOne("121"));
    }
}