package cn.mcandroid.pojo;

public class Stus {
    private String classes;
    private Stu stu;


    public Stus(String classes, Stu stu) {
        this.classes = classes;
        this.stu = stu;
    }

    public Stus() {
    }


    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }


    @Override
    public String toString() {
        return "Stus{" +
                "classes='" + classes + '\'' +
                ", stu=" + stu +
                '}';
    }
}
