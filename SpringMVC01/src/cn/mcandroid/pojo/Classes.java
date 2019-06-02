package cn.mcandroid.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Classes {
    private String name;
    private List<Stu> list;
    private int[] ints;
    private Set<Stu> set;
    private Map<String ,Stu> map;


    public Classes(String name, List<Stu> list, int[] ints, Set<Stu> set, Map<String, Stu> map) {
        this.name = name;
        this.list = list;
        this.ints = ints;
        this.set = set;
        this.map = map;
    }


    public Classes() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stu> getList() {
        return list;
    }

    public void setList(List<Stu> list) {
        this.list = list;
    }

    public int[] getInts() {
        return ints;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    public Set<Stu> getSet() {
        return set;
    }

    public void setSet(Set<Stu> set) {
        this.set = set;
    }

    public Map<String, Stu> getMap() {
        return map;
    }

    public void setMap(Map<String, Stu> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "name='" + name + '\'' +
                ", list=" + list +
                ", ints=" + Arrays.toString(ints) +
                ", set=" + set +
                ", map=" + map +
                '}';
    }
}
