package module2.case_study.model;

import java.time.LocalDate;

public abstract class Employee {
    protected int id ;
    protected String fullName;
    protected LocalDate date;
    protected double phone;
    protected String email;

    public Employee() {
    }

    public Employee(int id, String fullName,
                    LocalDate date, double phone, String email) {
        this.id = id;
        this.fullName = fullName;
        this.date = date;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", date=" + date +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}
