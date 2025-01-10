package example.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "ten khong duoc de trong")
    @Size(min=2, max=30,message = "ten phai toi thieu 2 ki tu, toi da 30 ki tu")
    private String username;

    @Min(value = 16,message = "tuoi phai tu 16")
    private int age;

    public User() {
    }


    public User (@NotBlank @Size(min=2, max=30)String username,@Min(value = 16) int age) {
        this.username = username;
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public int getAge() {
        return age;
    }

}
