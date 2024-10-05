package module2.ss16.customer.model;

import java.time.LocalDate;

public class Customer {
    private static int count =0;
    private int id;
    private String name;
    private LocalDate birthday;
    private String address;

    public Customer() {
    }

    public Customer(String name, LocalDate birthday, String address) {
        this.id = Customer.getCount();
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Customer.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return
                id +
                "," + name +
                "," + birthday +
                "," + address;
    }
}
