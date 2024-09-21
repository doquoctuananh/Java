package transports.model;

public abstract class Transports {
    private String numberPlate;
    private Manufacturter manufacturter;
    private int yearStart;
    private String ownTransport;

    public Transports() {
    }

    public Transports(String numberPlate, String ownTransport, int yearStart, Manufacturter manufacturter) {
        this.numberPlate = numberPlate;
        this.ownTransport = ownTransport;
        this.yearStart = yearStart;
        this.manufacturter = manufacturter;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getOwnTransport() {
        return ownTransport;
    }

    public void setOwnTransport(String ownTransport) {
        this.ownTransport = ownTransport;
    }

    public int getYearStart() {
        return yearStart;
    }

    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
    }

    public Manufacturter getManufacturter() {
        return manufacturter;
    }

    public void setManufacturter(Manufacturter manufacturter) {
        this.manufacturter = manufacturter;
    }

    @Override
    public String toString() {
        return "transports{" +
                "bien_kiem_soat='" + numberPlate + '\'' +
                ", hangsx='" + manufacturter + '\'' +
                ", namsx=" + yearStart +
                ", chu_so_huu='" + ownTransport + '\'' +
                '}';
    }
}
