package beanLife.bean;

/**
 * @Author @Chenxc
 * @Date 2022/4/22 12:11
 */
public class Car {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}

