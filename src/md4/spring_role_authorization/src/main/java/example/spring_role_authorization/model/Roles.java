package example.spring_role_authorization.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="role")
public class Roles {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    @OneToMany(mappedBy="roles",fetch = FetchType.LAZY,cascade= CascadeType.ALL)
    private List<Account> accounts;

    public Roles() {
    }

    public Roles(String name) {
        this.name = name;
    }

    public Roles(Long id, List<Account> accounts, String name) {
        this.id = id;
        this.accounts = accounts;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
