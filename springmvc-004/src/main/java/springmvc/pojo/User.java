package springmvc.pojo;

import java.util.Arrays;

public class User {
    private Long id;
    private String username;
    private String password;
    private Integer sex;
    private String[] interest;
    private String intro;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", interest=" + Arrays.toString(interest) +
                ", intro='" + intro + '\'' +
                ", age=" + age +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String[] getInterest() {
        return interest;
    }

    public void setInterest(String[] interest) {
        this.interest = interest;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(Long id, String username, String password, Integer sex, String[] interest, String intro, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.interest = interest;
        this.intro = intro;
        this.age = age;
    }

    public User() {
    }
}
