package module2.case_study.model;

import java.time.LocalDate;

public class Experience extends Employee {
    private static int count ;
    private final String employee_type = "Experience_employee";
    private int yearExper ;
    private String proskill;

    public Experience() {
    }

    public Experience(int yearExper, String proskill) {
        this.yearExper = yearExper;
        this.proskill = proskill;
    }

    public Experience(int id, String fullName, LocalDate date, double phone,
                      String email, int yearExper, String proskill) {
        super(id, fullName, date, phone, email);
        this.yearExper = yearExper;
        this.proskill = proskill;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Experience.count = count;
    }

    public String getEmployee_type() {
        return employee_type;
    }

    public int getYearExper() {
        return yearExper;
    }

    public void setYearExper(int yearExper) {
        this.yearExper = yearExper;
    }

    public String getProskill() {
        return proskill;
    }

    public void setProskill(String proskill) {
        this.proskill = proskill;
    }

    @Override
    public String toString() {
        return
                 id +
                "," + fullName +
                "," + date +
                "," + phone +
                "," + email +
                "," + yearExper+
                "," + proskill
                ;
    }
}
