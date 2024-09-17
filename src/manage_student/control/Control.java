package manage_student.control;

import manage_student.model.Student;
import manage_student.service.Manage;

import java.time.LocalDate;
import java.util.Scanner;

public class Control {
    public static void main(String[] args) {
        Student[] students  = new Student[50];
        students[0] = new Student(1,"Anh1","vietnam", LocalDate.of(2024,01,01));
        students[1] =  new Student(2,"anh2","vietnam",LocalDate.of(2024,01,02));

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Lua chon tuy nhap: \n" +
                    "1.Them sinh vien\n" +
                    "2.Tim kiem sinh vien ban can tim ma ID: \n" +
                    "3.Hien thi tat ca sinh vien \n" +
                    "4. Xoa thong tin sinh vien theo ID \n"+
                    "5. sua doi thong tin sinh vien \n" +
                    "6. Thoat");
            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:
                    Manage.creatStudent(students);
                    break;
                case 2:
                    System.out.println("nhap Id sinh vien ban tim ");
                    int _id = Integer.parseInt(sc.nextLine());
                    Manage.inforStudentID(students,_id);
                    break;
                case 3:
                    Manage.inforAllStudent(students);
                    break;
                case 4:
                    System.out.println("nhap ID sinh vien can xoa ");
                    int deleteID = Integer.parseInt(sc.nextLine());
                    Manage.deleteStudentID(students,deleteID);
                    break;
                case 5:
                    System.out.println("nhap Id thong tin sinh vien can sua doi ");
                    int id = Integer.parseInt(sc.nextLine());

                    Manage.updateStudentID(students,id);

                    break;

                case 6:
                    System.exit(0); break;

            }

        }
    }

}
