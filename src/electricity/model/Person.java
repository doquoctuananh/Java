package electricity.model;

import java.time.LocalDate;

public abstract class Person {
    private String idPerson;
    private String name;
    private String idBill ;
    private LocalDate dateBill ;
    private int consume;
    private float price;

    public Person() {
    }

    public Person(String idPerson, String name, String idBill, LocalDate dateBill, int consume, float price) {
        this.idPerson = idPerson;
        this.name = name;
        this.idBill = idBill;
        this.dateBill = dateBill;
        this.consume = consume;
        this.price = price;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public LocalDate getDateBill() {
        return dateBill;
    }

    public void setDateBill(LocalDate dateBill) {
        this.dateBill = dateBill;
    }

    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson='" + idPerson + '\'' +
                ", name='" + name + '\'' +
                ", idBill='" + idBill + '\'' +
                ", dateBill=" + dateBill +
                ", consume=" + consume +
                ", price=" + price +
                '}';
    }


    abstract double totalMoney();
}
