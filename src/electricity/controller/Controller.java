package electricity.controller;

import electricity.model.Foreign;
import electricity.model.Person;
import electricity.model.Vietnamese;
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
        File bill = new File(fileCustomer,"hoadon.csv");
        // xem file khachhang.csv da tom tại chua
        boolean isCustomer = Customer.exists();
        try{

            boolean created = Customer.createNewFile();

            // neu file khachhang.csv chua ton tai
            if(isCustomer) {
                if(created){
                    System.out.println("Create file khachhang.csv succesfully");
                    try (FileWriter fileWriterCustomer = new FileWriter(Customer, true)) {
                        fileWriterCustomer.write("idPerson,name, typeCustomer, limitConsume, country");

                    }
                }

            }
            // kiem tra xem loaikhach.csv da ton tai chua
            if(!typeCustomer.exists()){
                boolean createdtypeCustomer = typeCustomer.createNewFile();
                if(createdtypeCustomer){
                    System.out.println("Create file loaikhach.csv succesfully");
                }
                try (FileWriter fileWriterCustomer = new FileWriter(typeCustomer)) {
                    fileWriterCustomer.write("LKH,typeCustomer");
                }
            }
            //Kiem tra xem hoadon.csv co ton tai khong
            if(!bill.exists()){
                boolean createBill = bill.createNewFile();
                if(createBill){
                    System.out.println("Create file hoadon.csv succesfully");
                }
                try(FileWriter fileBill = new FileWriter(bill,true)){
                    fileBill.write("Mã hóa đơn, Mã khách hàng,  ngày ra hoá đơn .số lượng (số KW tiêu thụ), đơn giá, thành tiền.");

                }

            }

        }
        catch (IOException e){
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        //FileWriter fileWriteCustomer = new FileWriter("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/khachhang.csv",true);
        //FileWriter fileTypeCustomer = new FileWriter("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/loaikhach.csv",true);
        //FileReader fileSearchName = new FileReader("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/khachhang.csv");
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
                    //FileWriter fileWriteCustomer = new FileWriter("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/khachhang.csv",true);
                    //FileWriter fileTypeCustomer = new FileWriter("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/loaikhach.csv",true);
                    try(FileWriter fileWriteCustomer = new FileWriter("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/khachhang.csv",true)){
                        try(FileWriter fileTypeCustomer = new FileWriter("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/loaikhach.csv",true)){
                            ServiceElectricity.addCustomer(fileWriteCustomer,fileTypeCustomer);
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }


                    break;
                case 2:
                    System.out.println("Enter show Customer in khachhang.csv: \n" );
                    try(FileReader showInfo = new FileReader("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/khachhang.csv")){
                        ServiceElectricity.getInformation(showInfo);
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    ArrayList<Vietnamese> searchNameVn = new ArrayList<>();
                    ArrayList<Foreign> searchNameForeign = new ArrayList<>();
                    System.out.println("Enter search name: ");
                    String searchName = sc.nextLine();
                    //FileReader fileSearchName = new FileReader("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/khachhang.csv");
                    try(FileReader fileSearchName = new FileReader("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/khachhang.csv")){
                        ServiceElectricity.searchCustomerName(fileSearchName,searchNameVn,searchNameForeign,searchName.toLowerCase());
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 4:

                    try(FileReader showInfo = new FileReader("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/khachhang.csv")){
                        //ServiceElectricity.getInformation(showInfo);
                        try(FileWriter addBill = new FileWriter("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/hoadon.csv",true)){
                            ServiceElectricity.addBill(addBill,showInfo);
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }


                    break;
            }
        }
    }
}
