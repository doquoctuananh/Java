package module2.electricity.model;

import java.time.LocalDate;

public class Vietnamese extends Person{
    private String typeCustomer;
    private int limitConsume;

    public Vietnamese(String typeCustomer, int limitConsume) {
        this.typeCustomer = typeCustomer;
        this.limitConsume = limitConsume;
    }
    public Vietnamese(String idPerson, String name ,float price, String typeCustomer, int limitConsume) {
        super(idPerson, name,price);
        this.typeCustomer = typeCustomer;
        this.limitConsume = limitConsume;
    }

    public Vietnamese(String idPerson, String name, LocalDate dateBill, int consume, float price, String typeCustomer, int limitConsume) {
        super(idPerson, name, dateBill, consume, price);
        this.typeCustomer = typeCustomer;
        this.limitConsume = limitConsume;
    }

    public Vietnamese(String idPerson, String name, String typeCustomer, int limitConsume) {
        super(idPerson, name);
        this.typeCustomer = typeCustomer;
        this.limitConsume = limitConsume;
    }

    public Vietnamese(String idBill,String idPerson, LocalDate dateBill, int consume, float price) {
        super(idBill,idPerson, dateBill, consume, price);

    }

    public Vietnamese() {
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public int getLimitConsume() {
        return limitConsume;
    }

    public void setLimitConsume(int limitConsume) {
        this.limitConsume = limitConsume;
    }

    public double totalMoney(){
        double total=0;
        if(super.getConsume() <= this.getLimitConsume()){
            total = super.getConsume() * this.getPrice();
        }
        else{
            total = super.getConsume() * super.getPrice() * this.getLimitConsume() + (super.getConsume() - this.getLimitConsume()) * 2.5;

        }
        return total;
    }

    public String infoKhCsv() {
        return
                "id='" + super.getIdPerson() +'\''+
                ", name='" + super.getName() + '\'' +
                ", typeCustomer='" + this.getTypeCustomer()+'\'' +
                ", Limit quantity='" + this.getLimitConsume()+'\''
                ;
    }
    @Override
    public String toString() {
        return "Vietnam{" +
                "id='" + super.getIdPerson() +'\''+
                ", name='" + super.getName() + '\'' +
                ", idBill='" + super.getIdBill()+'\'' +
                ", dateBill='" + super.getDateBill()+'\'' +
                ", consume='" + super.getConsume()+'\'' +
                ", price='" + super.getPrice()+'\'' +
                ", typeCustomer='" + this.getTypeCustomer()+'\'' +
                ", Limit quantity='" + this.getLimitConsume()+'\'' +
                '}';
    }
}
