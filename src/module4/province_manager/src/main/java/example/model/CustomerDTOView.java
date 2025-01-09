package example.model;

public class CustomerDTOView {
    private String firstname;
    private String lastname;
    private String provincename;

    public CustomerDTOView() {
    }

    public CustomerDTOView(String firstname, String lastname, String provincename) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.provincename = provincename;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }
}
