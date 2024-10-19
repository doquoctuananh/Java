package module2.case_study.model;

import java.time.LocalDate;

public class Fresher extends Employee {
    private static int count;
    private LocalDate graduation_date;
    private String university;

    public Fresher() {
    }

    public Fresher(LocalDate graduation_date, String university) {
        this.graduation_date = graduation_date;
        this.university = university;
    }

    public Fresher(int id, String fullName, LocalDate date, double phone,
                   String email, LocalDate graduation_date, String university) {
        super(id, fullName, date, phone, email);
        this.graduation_date = graduation_date;
        this.university = university;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Fresher.count = count;
    }

    @Override
    public String toString() {
        return
                id + "," +fullName+
                "," + date +
                "," + phone +
                "," + email  +
                "," + graduation_date +
                "," + university
                ;
    }
}
