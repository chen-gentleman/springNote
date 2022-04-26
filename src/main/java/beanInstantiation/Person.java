package beanInstantiation;

/**下面这个类3个构造器，其中一个使用 @MyAutowried ，让其作为bean实例化的方法
 * @author @Chenxc
 * @date 2022年04月26日 21:21
 */
public class Person {
    private String name;
    private Integer age;

    public Person() {
    }

    @MyAutowried
    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
