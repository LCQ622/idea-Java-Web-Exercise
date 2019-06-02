package cn.mcandoird.test;

import cn.mcandoird.Util;
import cn.mcandoird.mapper.EmployeeMapper;
import cn.mcandoird.pojo.Employee;
import cn.mcandoird.service.EmployeeService;
import cn.mcandoird.service.impl.EmployeeServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestEmp {

    /**
     * 该方法用于测试 EmployeeMapper 接口中 的 findAll方法是否返回查询的数据
     */
    @Test
    public void t1() {
        SqlSession session = Util.getSqlSession();

        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.findAll();
        for (Employee e :list) {
            System.out.println(e);
        }
        Util.closs(session);
    }

    /**
     * 该方法用于测试 EmployeeService 中的findAllToJson方法是否能返回json数据
     */
    @Test
    public void t2(){
        EmployeeService service=new EmployeeServiceImpl();
        System.out.println(service.findAllToJson());
    }

    @Test
    public  void t3(){
        SqlSession session=Util.getSqlSession();
        EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
        Employee e=new Employee();
        e.setId(1);
        e.setGender("男");


        List<Employee>list=mapper.getEmpByEmp(e);


        System.out.println(list.size());
        session.commit();
        session.close();
    }


}
