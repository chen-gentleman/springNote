package bean;

import java.util.List;
import java.util.Map;

/**
 * @Author @Chenxc
 * @Date 2022/4/14 16:12
 */
public class User2 {
    private String username;
    private Integer age;
    private List<String> hobby;
    private Map<String, Integer> petsAge;


    public String userAndAddress(){
        Address address = this.getAddress();
        return this + "address= "+address;
    }

    public Address getAddress(){
        return null;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public Map<String, Integer> getPetsAge() {
        return petsAge;
    }

    public void setPetsAge(Map<String, Integer> petsAge) {
        this.petsAge = petsAge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", hobby=" + hobby +
                ", petsAge=" + petsAge +
                '}';
    }
}
