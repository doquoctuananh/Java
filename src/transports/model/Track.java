package transports.model;

public class Track extends Transports{
    private double payload;

    public Track(double payload) {
        this.payload = payload;
    }

    public Track(String numberPlate, String ownTransport, int yearStart, Manufacturter manufacturter, double payload) {
        super(numberPlate, ownTransport, yearStart, manufacturter);
        this.payload = payload;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Car transports{" +
                "bien_kiem_soat='" + super.getNumberPlate() + '\'' +
                ", hangsx='" + super.getManufacturter() + '\'' +
                ", namsx=" + super.getYearStart() +
                ", chu_so_huu='" + super.getOwnTransport() + '\'' +
                ", trong_tai= '" + this.getPayload() +'\'' +

                '}';
    }
}
