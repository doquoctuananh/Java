package module2.case_study.controller;

import module2.case_study.service.ServiceEmployee;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // mieu ta bai toan case study
        File fileDescription = new File ("src/module2/case_study/description_case_study.txt");
        ServiceEmployee.createFile(fileDescription);
        // create file save information employee
        File fileExperience = new File ("src/module2/case_study/data/experience.csv");
        File fileFresher = new File ("src/module2/case_study/data/fresher.csv");
        File fileIntern = new File ("src/module2/case_study/data/intern.csv");

        ServiceEmployee.createFile(fileExperience);
        ServiceEmployee.createFile(fileFresher);
        ServiceEmployee.createFile(fileIntern);

        //create folder save certificate employee
        File certificateFolder = new File("src/module2/case_study/data/Certificate");
        ServiceEmployee.createFolder(certificateFolder);

        File certificateExperience = new File(certificateFolder,"cert_experience.csv");
        File certificateFresher = new File(certificateFolder,"cert_fresher.csv");
        File certificateIntern = new File(certificateFolder,"cert_intern.csv");

        ServiceEmployee.createFile(certificateExperience);
        ServiceEmployee.createFile(certificateFresher);
        ServiceEmployee.createFile(certificateIntern);

        while(1>0){
            System.out.println("Menu: \n" +
                    "1.Add Employee \n" +
                    "2.Show Inofrmation Employee \n" +
                    "3.Update information Employee\n" +
                    "4.Search Employee\n" +
                    "5.Delete employee\n" +
                    "6.Watch total certificate as employee\n" +
                    "7.Exits");
            int option = Integer.parseInt(sc.nextLine());
            switch(option){
                case 1 : {
                    try{
                        ServiceEmployee.addEmployee(fileExperience,fileFresher,fileIntern,
                                certificateExperience,certificateFresher,certificateIntern);
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    ServiceEmployee.showInformation(fileExperience,fileFresher,fileIntern);
                    break;
                }
                case 3:{
                    ServiceEmployee.updateEmployee(fileExperience,fileFresher,fileIntern);
                    break;
                }
                case 4: {
                    ServiceEmployee.searchEmployee(fileExperience,fileFresher,fileIntern);
                    break;
                }
                case 5:{
                    ServiceEmployee.deleteEMployeeId(fileExperience,fileFresher,fileIntern,
                            certificateExperience,certificateFresher,certificateIntern);
                    break;
                }
                case 6:{
                    ServiceEmployee.totalEmployeeHasCert(fileExperience,fileFresher,fileIntern,
                            certificateExperience,certificateFresher,certificateIntern);
                    break;
                }
                case 7:{
                    System.exit(0);
                }
            }
        }
    }
}
