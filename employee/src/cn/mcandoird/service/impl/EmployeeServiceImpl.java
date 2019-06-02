package cn.mcandoird.service.impl;

import cn.mcandoird.Util;
import cn.mcandoird.mapper.EmployeeMapper;
import cn.mcandoird.pojo.Employee;
import cn.mcandoird.service.EmployeeService;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeMapper mapper = null;
    private static SqlSession session = null;


    /**
     * 该方法查询所有数据
     * @return   List<Employee>
     */
    @Override
    public List<Employee> findAll() {
        session = Util.getSqlSession();
        mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.findAll();
        Util.closs(session);
        return list;
    }


    /**
     * 该方法将查询到的所有数据转换成json 数据
     * @return  String 类型的json数据
     */
    @Override
    public String findAllToJson() {
        session = Util.getSqlSession();
        mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.findAll();
        Gson gson = new Gson();
        Util.closs(session);
        return gson.toJson(list);
    }
}
