package example.restful_customer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotBlank(message="khong duoc de trong")
    @Size(min = 4,message = "toi thieu 4 ki tu")
    @Column(name = "firstname",columnDefinition = "varchar(50) not null")
    private String firstName;

    @NotBlank(message = "khong duoc de trong")
    @Size(min = 3,message = "toi thieu 3 ki tu")
    @Column(name = "lastname",columnDefinition="varchar(30) not null")
    private String lastName;

    public Customer() {
    }

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
