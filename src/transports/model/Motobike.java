package transports.model;

public class Motobike extends Transports{
    private String capacity;

    public Motobike(String capacity) {
        this.capacity = capacity;
    }

    public Motobike(String numberPlate, String ownTransport, int yearStart, Manufacturter manufacturter, String capacity) {
        super(numberPlate, ownTransport, yearStart, manufacturter);
        this.capacity = capacity;
    }

    public Motobike() {
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Motobike {" +
                "bien_kiem_soat='" + super.getNumberPlate() + '\'' +
                ", hangsx='" + super.getManufacturter().toString() + '\'' +
                ", namsx=" + super.getYearStart() +
                ", chu_so_huu='" + super.getOwnTransport() + '\'' +
                ", cong_suat= '" + this.getCapacity() +'\'' +

                '}';
    }
}
