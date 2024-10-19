package module2.test;

import module2.test.model.Student;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Student> stu = new HashSet<>();
        Student student1 = new Student("tuan anh","quocanhanh1204@gmail.com");
        Student student2 = new Student("tuan anh","quocanhanh1204@gmail.com");
        stu.add(student1);
        stu.add(student2);
        System.out.println(stu);
    }

}
