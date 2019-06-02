package cn.mcandroid.pojo;

public class School {
    private  static  School instance=new School();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  School(){

    }



    public static  School getInstance(){
        return  instance;
    }


    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                '}';
    }
}
