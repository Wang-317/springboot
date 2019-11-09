package com.offcn.springboot.service;

import com.offcn.springboot.bean.Employee;
import com.offcn.springboot.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    EmployeeDao employeeDao;

    @Override/*登录方法*/
    public Employee login(Integer eid,String ename) {
        return employeeDao.findByEidAndEname(eid,ename);
    }

    @Override
    public Page<Employee> showInfo(Integer currentPage) {
       Sort.Order order1 = new Sort.Order(Sort.Direction.DESC,"eid");
       Sort sort = Sort.by(order1);
        PageRequest pageable = PageRequest.of(currentPage,2,sort);
        Page<Employee> page = employeeDao.findAll(pageable);
        return page;
    }

    @Override
    public boolean deleteInfo(Integer eid) {
        employeeDao.deleteById(eid);
        return true;
    }


}
