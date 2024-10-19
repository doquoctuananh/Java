package module2.case_study.model;

import java.time.LocalDate;

public class Certificate {
    private String certificatedID;
    private String cerificatedName;
    private String certificateRank;
    private LocalDate certificateDate;

    public Certificate() {

    }

    public Certificate(String certificatedID, String cerificatedName,
                       String certificateRank, LocalDate certificateDate) {
        this.certificatedID = certificatedID;
        this.cerificatedName = cerificatedName;
        this.certificateRank = certificateRank;
        this.certificateDate = certificateDate;
    }

    public void setCeritificatedID(String CertificatedID){
        this.certificatedID = CertificatedID;
    }
    public String getCertificatedID(){
        return this.certificatedID;
    }

    public String getCerificatedName() {
        return cerificatedName;
    }

    public void setCerificatedName(String cerificatedName) {
        this.cerificatedName = cerificatedName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public LocalDate getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(LocalDate certificateDate) {
        this.certificateDate = certificateDate;
    }

    @Override
    public String toString() {
        return  certificatedID +
                "," + cerificatedName +
                "," + certificateRank +
                "," + certificateDate ;
    }
}
