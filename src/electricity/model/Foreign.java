package electricity.model;

import java.time.LocalDate;

public class Foreign extends Person{
    private String country;

    public Foreign() {
    }

    public Foreign(String country) {
        this.country = country;
    }

    public Foreign(String idPerson, String name, String idBill, LocalDate dateBill, int consume, float price, String country) {
        super(idPerson, name, idBill, dateBill, consume, price);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return "Foreign{" +
                "id='" + super.getIdPerson() +'\''+
                ", name='" + super.getName() + '\'' +
                ", idBill='" + super.getIdBill()+'\'' +
                ", dateBill='" + super.getDateBill()+'\'' +
                ", consume='" + super.getConsume()+'\'' +
                ", price='" + super.getPrice()+'\'' +
                ", Country='" + this.getCountry()+'\'' +
                '}';
    }

    public double totalMoney(){
        return super.getConsume() * super.getPrice();
    }
}
