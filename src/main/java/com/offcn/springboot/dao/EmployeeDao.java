package com.offcn.springboot.dao;

import com.offcn.springboot.bean.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeDao extends PagingAndSortingRepository<Employee,Integer> {
    /*登录*/
    Employee findByEidAndEname(Integer eid, String ename);

    @Query("from  Employee")
    public List<Employee> findAllInfo();
}
