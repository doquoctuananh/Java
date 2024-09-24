package electricity.service;

import electricity.model.Foreign;
import electricity.model.Person;
import electricity.model.Vietnamese;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceElectricity {

    Scanner sc = new Scanner(System.in);
    // them khach hang
    public static void addCustomer(ArrayList<Person> vietnam, ArrayList<Person> foreign, FileWriter fileWriter,FileWriter fileTypeCustomer) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose type Customer: \n" +
                "1. Vietamese\n" +
                "2. Foreign");
        int optionCustomer = Integer.parseInt(sc.nextLine());
        switch (optionCustomer){
            case 1:
                System.out.println("Enter Customer code(ex:KHVN-XXXXX (X : 0÷9))");
                int id = Integer.parseInt(sc.nextLine());
                String codeCustomer = "KHVN-"+id;
                System.out.println("Enter name Customer: ");
                String nameCustomer = sc.nextLine();
                System.out.println("Enter Type Customer: \n" +
                        "1. Living\n" +
                        "2. Business\n" +
                        "3. Production");
                int optionType = Integer.parseInt(sc.nextLine());
                String typeCustomer=null;
                switch (optionCustomer){
                    case 1:
                        typeCustomer = "Living";
                        break;
                    case 2:
                        typeCustomer = "Business";
                        break;
                    case 3:
                        typeCustomer = "Production";
                        break;
                }
                System.out.println("Enter limit quantity ");
                int limitQuantity = Integer.parseInt(sc.nextLine());
                System.out.println("Enter code bill(MHD-XXX(X : 0÷9))");
                String codeBill= sc.nextLine();
                System.out.println("Enter date out bill");
                LocalDate dateBill = LocalDate.parse(sc.nextLine());
                System.out.println("Enter Kw quatity");
                int kwQuantity = Integer.parseInt(sc.nextLine());
                System.out.println("Enter Price");
                float price = Float.parseFloat(sc.nextLine());

                // them khach hang vao khachhang.csv
                String rowCustomer = "\n"+codeCustomer.toUpperCase()+ ","+nameCustomer+","+ price+ ","+typeCustomer+ ","+limitQuantity+ ","+"Vietnam";
                fileWriter.write(rowCustomer);
                fileWriter.flush();
                fileWriter.close();

                // them loai khach hang vao loaikhach.csv
                String rowtypeCustomer = "\n"+"LKH-"+id+ "," +typeCustomer;
                fileTypeCustomer.write(rowtypeCustomer);
                fileTypeCustomer.flush();
                fileTypeCustomer.close();

                Vietnamese customer = new Vietnamese(codeCustomer.toUpperCase(),nameCustomer,codeBill.toUpperCase(),dateBill,kwQuantity,price,typeCustomer,limitQuantity);
                vietnam.add(customer);
                break;
            case 2:
                System.out.println("Enter Customer code(ex:KHNN-XXXXX (X : 0÷9))");
                int _id = Integer.parseInt(sc.nextLine());
                String _codeCustomer = "KHNN-"+_id;
                System.out.println("Enter name Customer: ");
                String _nameCustomer = sc.nextLine();
                System.out.println("Enter name Country: ");
                String _nameCountry = sc.nextLine();

                System.out.println("Enter code bill(ex:MHD-XXX(X : 0÷9))");
                String _codeBill= sc.nextLine();
                System.out.println("Enter date out bill");
                LocalDate _dateBill = LocalDate.parse(sc.nextLine());
                System.out.println("Enter Kw quatity");
                int _kwQuantity = Integer.parseInt(sc.nextLine());
                System.out.println("Enter Price");
                float _price = Float.parseFloat(sc.nextLine());

                Foreign _foreign = new Foreign(_codeCustomer,_nameCustomer,_codeBill,_dateBill,_kwQuantity,_price,_nameCountry.toUpperCase());
                foreign.add(_foreign);

                // them khach hang vao khachhang.csv
                String rowCustomerForeign = "\n"+_codeCustomer.toUpperCase()+ ","+_nameCustomer+","+ _price+ ","+"null"+ ","+"null"+ ","+_nameCountry.toUpperCase();
                fileWriter.write(rowCustomerForeign);
                fileWriter.flush();
                fileWriter.close();

                // them loai khach hang vao loaikhach.csv
//                String rowtypeCustomerForeign = "\n"+"LKH"+_id+ "," +"null";
//                fileWriter.write(rowtypeCustomerForeign);
//                fileWriter.flush();
//                fileWriter.close();
                break;

        }
    }

    // tim kiem khach hang
    public static void getInformation(ArrayList<Person> person){
        for (int i = 0; i < person.size(); i++) {
            System.out.println(person.get(i).toString());
        }
    }

    // tim kiem khach hang trong file khachhang.csv
    public static void searchCustomerName(FileReader fileSearchName){
        

    }
}
