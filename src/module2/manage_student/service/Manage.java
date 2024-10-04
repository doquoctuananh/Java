package module2.manage_student.service;

import module2.manage_student.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class Manage {

    // them sinh vien
    public static void creatStudent(Student[] students){
        for (int i = 0; i < students.length; i++) {
            if(students[i] == null){
                Scanner sc = new Scanner(System.in);

                System.out.println("nhap id: ");
                int _id = Integer.parseInt(sc.nextLine());

                System.out.println("nhap ten sinh vien: ");
                String _name = sc.nextLine();

                System.out.println("nhap ten dia chi: ");
                String _address = sc.nextLine();

                System.out.println("nhap ngay sinh sinh vien: ");
                LocalDate _birthday = LocalDate.parse(sc.nextLine());

                students[i] = new Student(_id,_name,_address,_birthday);
                break;
            }
        }
    }

    //    tim kiem sinh vien theo ID
    public static void inforStudentID(Student[] students,int id){
        int findIndex = 0;
        for (int i = 0; i < students.length; i++) {

            if( students[i] != null && students[i].getId() == id){
                System.out.println("thong tin sinh vien " + students[i].toString());
                findIndex++;
                break;
            }

        }
        if(findIndex>0){

        }
        else{
            System.out.println("khong ton tai sinh vien co ma ID " + id);
        }
    }

    // hien thi tat va sinh vien
    public static void inforAllStudent(Student [] students){
        for (int i = 0; i < students.length; i++) {
            if(students[i] != null){
                System.out.println(students[i].toString());
            }
            else{
                break;
            }

        }
    }

    // Xoa sinh vien theo ID
    public static void deleteStudentID(Student[] students,int _id){
        int booleanID = -1;
        for (int i = 0; i < students.length; i++) {
            if( students[i] != null && students[i].getId() ==_id ){
                booleanID =i;
                break;
            }
        }
        if(booleanID !=-1){
            for (int i = booleanID; i < students.length-1; i++) {
                students[i]=students[i+1];
                if(students[i]==null){
                    break;
                }
            }
            students[students.length-1]=null;
            System.out.println("sinh vien da duoc xoa");
        }
        else{
            System.out.println("khong ton tai sinh vien ma ID la :" + _id + " can xoa");
        }

    }

    // update thong tin sinh vien
    public static void updateStudentID(Student[] students,int _id){
        int findIndexId = -1;

        for (int i = 0; i < students.length; i++) {
            if(students[i] != null && students[i].getId() ==_id){
                findIndexId = i;
                break;
            }
        }
        if(findIndexId != -1){
            Scanner sc = new Scanner(System.in);

            System.out.println("cap nhat " + _id + " thanh id moi la: ");
            int updateID = Integer.parseInt(sc.nextLine());

            System.out.println("cap nhat lai ten sinh vien ");
            String updateName = sc.nextLine();

            System.out.println("nhap ten dia chi: ");
            String updateAddress = sc.nextLine();

            System.out.println("nhap ngay sinh sinh vien: ");
            LocalDate updateBirthday = LocalDate.parse(sc.nextLine());

            students[findIndexId].setId((updateID));
            students[findIndexId].setName(updateName);
            students[findIndexId].setAddress(updateAddress);
            students[findIndexId].setBirthday(updateBirthday);
        }
        else{
            System.out.println("khong ton tai sinh vien ma Id :" + _id );
        }
    }



//    public static void main(String[] args) {
//        Student[] students  = new Student[50];
//        students[0] = new Student(1,"Anh1");
//        students[1] = new Student(2,"Anh2");
//
//
//    }
}
