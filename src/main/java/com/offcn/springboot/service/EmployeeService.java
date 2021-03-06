package com.offcn.springboot.service;

import com.offcn.springboot.bean.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {
    /*
    * 登录
    * */
    Employee login(Integer eid,String ename);

    Page<Employee> showInfo(Integer currentPage);

    boolean deleteInfo(Integer eid);
}
