//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class student{
    public static String name = "Tuan anh";

}
public class Main {

    public static void main(String[] args) {
        student a = new student();
        student b = new student();
        System.out.println(a.name);
        b.name = "Quoc duy";
        System.out.println(b.name);
        System.out.println(a.name);
        System.out.println(student.name);
    }
}