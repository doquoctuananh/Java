package module2.case_study.model;

import java.time.LocalDate;

public class Intern extends Employee{
    private static int count ;
    private String major;
    private String semester;
    private String university_name;

    public Intern() {
    }

    public Intern(int id, String fullName, LocalDate date, double phone,
                  String email, String major, String semester, String university_name) {
        super(id, fullName, date, phone, email);
        this.major = major;
        this.semester = semester;
        this.university_name = university_name;
    }

    public Intern(String major, String semester, String university_name) {
        this.major = major;
        this.semester = semester;
        this.university_name = university_name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Intern.count = count;
    }

    @Override
    public String toString() {
        return  id +
                "," + fullName  +
                "," + date +
                "," + phone +
                "," + email  +
                "," + major +
                "," + semester +
                "," + university_name  ;
    }
}
