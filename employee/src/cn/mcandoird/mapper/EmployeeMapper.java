package cn.mcandoird.mapper;

import cn.mcandoird.pojo.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper {
    List<Employee>  findAll();
    @Select("select *from employee where gender=#{gender}")
    List<Employee>  getEmpByEmp(Employee employee);



}
