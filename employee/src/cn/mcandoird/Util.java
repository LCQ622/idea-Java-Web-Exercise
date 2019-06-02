package cn.mcandoird;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 该工具类用于获取 mybatis 的SqlSession
 */
import java.io.IOException;

public class Util {
    public  static SqlSession getSqlSession(){
        try {
            SqlSessionFactory factory =new SqlSessionFactoryBuilder().build( Resources.getResourceAsStream("mybatis.xml"));
            return factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static  void closs(SqlSession session){
        if(session!=null){
            session.close();
        }
    }


}
