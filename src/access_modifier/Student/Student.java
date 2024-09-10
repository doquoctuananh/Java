package access_modifier.Student;

class Student {
    private String name ="John";
    private String classes ="C02";
    public Student(){

    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }
}
