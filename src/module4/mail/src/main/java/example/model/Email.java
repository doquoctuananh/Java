package example.model;

public class Email {
    private String language;
    private int pagesize;
    private boolean spams;
    private String signature   ;

    public Email() {
    }

    public Email(String language, int pagesize, boolean spams, String signature) {
        this.language = language;
        this.pagesize = pagesize;
        this.spams = spams;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public boolean isSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
