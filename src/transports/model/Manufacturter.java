package transports.model;

public class Manufacturter {

    private String codeManufacturter;
    private String nameManufacturter;
    private String country;

    public Manufacturter() {
    }

    public Manufacturter(String codeManufacturter, String nameManufacturter, String country) {
        this.codeManufacturter = codeManufacturter;
        this.nameManufacturter = nameManufacturter;
        this.country = country;
    }

    public String getCodeManufacturter() {
        return codeManufacturter;
    }

    public void setCodeManufacturter(String codeManufacturter) {
        this.codeManufacturter = codeManufacturter;
    }

    public String getNameManufacturter() {
        return nameManufacturter;
    }

    public void setNameManufacturter(String nameManufacturter) {
        this.nameManufacturter = nameManufacturter;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Manufacturter{" +
                "codeManufacturter='" + this.getCodeManufacturter() + '\'' +
                ", nameManufacturter='" + this.getNameManufacturter() + '\'' +
                ", country='" + this.getCountry() + '\'' +
                '}';
    }
}
