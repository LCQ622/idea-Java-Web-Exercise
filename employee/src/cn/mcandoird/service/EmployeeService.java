package cn.mcandoird.service;

import cn.mcandoird.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * 该方法查询所有数据
     * @return   List<Employee>
     */
    List<Employee> findAll();

    /**
     * 该方法将查询到的所有数据转换成json 数据
     * @return  String 类型的json数据
     */
    String findAllToJson();
}
