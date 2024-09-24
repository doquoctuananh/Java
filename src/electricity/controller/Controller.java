package electricity.controller;

import electricity.model.Person;
import electricity.service.ServiceElectricity;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws IOException {
        ArrayList<Person> vietnam = new ArrayList<>();
        ArrayList<Person> foreign = new ArrayList<>();

        File fileCustomer = new File("Electricity_Customer");
        if(!fileCustomer.exists()){
            fileCustomer.mkdir();
        }


        // create file khachhang.csv
        File Customer = new File(fileCustomer,"khachhang.csv");
        File typeCustomer = new File(fileCustomer,"loaikhach.csv");

        try{

            boolean created = Customer.createNewFile();
            if(!Customer.exists()){
                if(created){
                    System.out.println("Create file khachhang.csv succesfully");

                }
                else{
                    System.out.println("Create file khachhang.csv Fail");
                }
            }
            try (FileWriter fileWriterCustomer = new FileWriter(Customer)) {
                fileWriterCustomer.write("idPerson, name, price, typeCustomer, limitConsume, country");

            }

            boolean createdtypeCustomer = typeCustomer.createNewFile();
            if(!typeCustomer.exists()){
                if(createdtypeCustomer){
                    System.out.println("Create file loaikhach.csv succesfully");

                }
                else{
                    System.out.println("Create file loaikhach.csv Fail");
                }
            }
            try (FileWriter fileWriterCustomer = new FileWriter(typeCustomer)) {
                fileWriterCustomer.write("LKH,typeCustomer");

            }



        }
        catch (IOException e){
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        while(1>0){
            System.out.println("Menu \n" +
                    "1. Add Customer \n" +
                    "2. Show information Customer: \n" +
                    "3. Search Customer \n" +
                    "4. Extra bill \n" +
                    "5. Fix bill \n" +
                    "6. Show detail bill \n" +
                    "7. Exit");
            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:
                    FileWriter fileWriteCustomer = new FileWriter("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/khachhang.csv",true);
                    FileWriter fileTypeCustomer = new FileWriter("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/loaikhach.csv",true);
                    ServiceElectricity.addCustomer(vietnam,foreign,fileWriteCustomer,fileTypeCustomer);

                    break;
                case 2:
                    System.out.println("Enter show type Customer: \n" +
                            "1. Vietnam\n" +
                            "2. Foreign");
                    int optionTypeCustomer = Integer.parseInt(sc.nextLine());
                    if(optionTypeCustomer==1){
                        ServiceElectricity.getInformation(vietnam);
                    }
                    else if(optionTypeCustomer==2){
                        ServiceElectricity.getInformation(foreign);
                    }

                    break;
                case 3:
                    FileReader fileSearchName = new FileReader("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/khachhang.csv");
                    ServiceElectricity.searchCustomerName(fileSearchName);
                    break;
            }
        }
    }
}
