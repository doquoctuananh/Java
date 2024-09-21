package transports.model;

public class Car extends Transports {
    private int numberSeat;
    private String typeCar;

    public Car(int numberSeat, String typeCar) {
        this.numberSeat = numberSeat;
        this.typeCar = typeCar;
    }

    public Car(String numberPlate, String ownTransport, int yearStart, Manufacturter manufacturter, int numberSeat, String typeCar) {
        super(numberPlate, ownTransport, yearStart, manufacturter);
        this.numberSeat = numberSeat;
        this.typeCar = typeCar;
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(int numberSeat) {
        this.numberSeat = numberSeat;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public String toString() {
        return "Car {" +
                "bien_kiem_soat='" + super.getNumberPlate() + '\'' +
                ", hangsx='" + super.getManufacturter().toString() + '\'' +
                ", namsx=" + super.getYearStart() +
                ", chu_so_huu='" + super.getOwnTransport() + '\'' +
                ", so_cho _ngoi= '" + this.getNumberSeat() +'\'' +
                ", Loai xe= '" + this.getTypeCar()+ '\'' +
                '}';
    }
}
