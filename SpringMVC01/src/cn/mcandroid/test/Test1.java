package cn.mcandroid.test;

import cn.mcandroid.pojo.Classes;
import cn.mcandroid.pojo.School;
import cn.mcandroid.pojo.Stu;
import cn.mcandroid.pojo.Stus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Test1 {
    private static ApplicationContext ac=null;
    public static void main(String[] args) {
       ac = new ClassPathXmlApplicationContext("application.xml");
        Classes c=ac.getBean("classes" , Classes.class);
        System.out.println("获取name："+c.getName());
        System.out.println("获取list："+c.getList());
        System.out.println("获取Array:"+ Arrays.toString(c.getInts()));
        System.out.println("获取set:"+c.getSet());
        System.out.println("获取map:"+c.getMap());
    }


    /**
     * 该方法用于获得所有的bean 名称
     */
    public static void  t1(){
        for (String tr : ac.getBeanDefinitionNames()) {
            System.out.println(tr);
            Object obj=ac.getBean(tr);
            System.out.println(obj);
        }
    }

    /**
     * 该方法用于获取普通注入的对象
     */
    public static void t2(){
        Stu s = ac.getBean("stu", Stu.class);
        System.out.println(s);
    }

    /**
     * 该方法用于获取带有依赖的对象
     */
    public static  void t3(){
        Stus s2 = ac.getBean("stus", Stus.class);
        System.out.println(s2);
    }


    /**
     * 该方法用于获取在spring配置文件中使用构造器传参的对象
     */
    public  static  void t4(){
        Stu s3 = ac.getBean("stu2", Stu.class);
        System.out.println(s3);
    }

    /**
     * 该方法用于获取在spring配置文件中使用构造器传入依赖的对象
     */
    public static  void t5(){
        Stus s4= ac.getBean("stus2",Stus.class);
        System.out.println(s4);
    }


    /**
     * 该方法用于测试使用 工厂创建单例
     * 可以看到 修改一处 的对象 ，其他的也会跟着改变
     */
    public  static  void  t6(){
        School school1 =ac.getBean("school",School.class);
        School school2 =ac.getBean("school",School.class);
        school2.setName("中戏");

        System.out.println(school1);
        System.out.println(school2);

        school2.setName("北邮");

        System.out.println(school1);
        System.out.println(school2);
    }


    /**
     * 该方法用于测试spring 中默认配置的bean 就是单例
     */
    public  static  void t7(){
        Stu s1=ac.getBean("stu",Stu.class);
        Stu s2=ac.getBean("stu",Stu.class);
        System.out.println(s1);
        System.out.println(s2);
        s2.setName("真好玩");
        System.out.println(s1);
        System.out.println(s2);
    }


    /**
     *  该变spring 中的默认单例模式
     */
    public static  void t8(){
        Stu s1=ac.getBean("stu3",Stu.class);
        Stu s2=ac.getBean("stu3",Stu.class);
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);
        s2.setName("真好玩");
        //发生改变后只改变s2的name值
        System.out.println("**************************************");
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);

    }


    /**
     * 测试带有集合属性的注入
     */
    public static  void t9(){
        Classes c=ac.getBean("classes" , Classes.class);
        System.out.println("获取name："+c.getName());
        System.out.println("获取list："+c.getList());
        System.out.println("获取Array:"+ Arrays.toString(c.getInts()));
        System.out.println("获取set:"+c.getSet());
        System.out.println("获取map:"+c.getMap());
    }
}
