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
    public static void addCustomer( FileWriter fileWriter,FileWriter fileTypeCustomer) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose type Customer: \n" +
                "1. Vietamese\n" +
                "2. Foreign");
        int optionCustomer = Integer.parseInt(sc.nextLine());
        switch (optionCustomer){
            case 1:
                System.out.println("Enter Customer code(ex:XXXXX (X : 0÷9))");
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
                // them khach hang vao khachhang.csv
                String rowCustomer = "\n"+codeCustomer.toUpperCase()+ ","+nameCustomer+"," +typeCustomer+ ","+limitQuantity;
                fileWriter.write(rowCustomer);
                fileWriter.flush();
                fileWriter.close();

                // them loai khach hang vao loaikhach.csv
                String rowtypeCustomer = "\n"+"LKH-"+id+ "," +typeCustomer;
                fileTypeCustomer.write(rowtypeCustomer);
                fileTypeCustomer.flush();
                fileTypeCustomer.close();


                break;
            case 2:
                System.out.println("Enter Customer code(ex:XXXXX (X : 0÷9))");
                int _id = Integer.parseInt(sc.nextLine());
                String _codeCustomer = "KHNN-"+_id;
                System.out.println("Enter name Customer: ");
                String _nameCustomer = sc.nextLine();
                System.out.println("Enter name Country: ");
                String _nameCountry = sc.nextLine();

                // them khach hang vao khachhang.csv
                String rowCustomerForeign = "\n"+_codeCustomer.toUpperCase()+ ","+_nameCustomer+ ","+_nameCountry.toUpperCase();
                fileWriter.write(rowCustomerForeign);
                fileWriter.flush();
                fileWriter.close();
                break;

        }
    }

    // hien thi khach hang trong file khachhang.csv
    public static void getInformation(FileReader showInfo) throws IOException {
        BufferedReader bufferReader = new BufferedReader(showInfo);
        String reader = null;
        while((reader = bufferReader.readLine())!= null){
            if(reader.contains("idPerson")){
                continue;
            }
            else{
                System.out.println(reader);
            }
        }
        bufferReader.close();
    }

    // tim kiem khach hang trong file khachhang.csv
    public static void searchCustomerName(FileReader fileSearchName,ArrayList<Vietnamese> searchNameVn,ArrayList<Foreign> searchNameForeign,String searchName) throws IOException {
        BufferedReader bufferReader = new BufferedReader(fileSearchName);
        String reader = null;
        while ((reader = bufferReader.readLine() )!= null){
            String[] splitRow = reader.split(",");
            if(splitRow[1].toLowerCase().contains(searchName)){
                if(splitRow.length ==4){
                    Vietnamese vietnamese = new Vietnamese(splitRow[0], splitRow[1] ,splitRow[2],Integer.parseInt(splitRow[3]));
                    searchNameVn.add(vietnamese);
                }
                else if(splitRow.length==3){
                    Foreign foreign = new Foreign(splitRow[0], splitRow[1], splitRow[2]);
                    searchNameForeign.add(foreign);
                }
            }
        }
        bufferReader.close();
       for (Vietnamese vietnamese : searchNameVn){
           System.out.println(vietnamese.infoKhCsv());
       }
        for (int i = 0; i < searchNameForeign.size(); i++) {
            System.out.println(searchNameForeign.get(i).inforForeignKhCsv());
        }
    }

    // chuc nang them hoa don
    public static void addBill(FileWriter addBill,FileReader showInfo) throws IOException {
        BufferedReader bufferReader = new BufferedReader(showInfo);
        String reader = null;
        while((reader = bufferReader.readLine())!= null){
            if(reader.contains("idPerson")){
                continue;
            }
            else{
                System.out.println(reader);
            }
        }
        bufferReader = new BufferedReader(new FileReader("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/khachhang.csv"));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id Person chose");
        String idPerson = sc.nextLine();

        System.out.println("Enter date out bill");
        LocalDate dateBill = LocalDate.parse(sc.nextLine());
        System.out.println("Enter Kw quatity");
        int kwQuantity = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Price");
        float price = Float.parseFloat(sc.nextLine());


        while((reader = bufferReader.readLine())!= null){

            String[] splitRow = reader.split(",");
            
            if(splitRow[0].toUpperCase().equals(idPerson.toUpperCase())){
                if(splitRow[0].toUpperCase().contains("KHVN")){
                    int count = Person.count++;
                    String mhd = Person.idBill;
                    Vietnamese vn = new Vietnamese(mhd,splitRow[0],dateBill,kwQuantity,price);
                    vn.setLimitConsume(Integer.parseInt(splitRow[3]));
                    String bill = "\n"+mhd+","+splitRow[0]+","+dateBill+","+kwQuantity+","+price+","+ vn.totalMoney();
                    System.out.println(bill);
                    addBill.write(bill);
                }
                else if(splitRow[0].toUpperCase().contains("KHNN")){
                    int count = Person.count++;
                    String mhd = Person.idBill;
                    Foreign foreign = new Foreign(mhd,splitRow[0],dateBill,kwQuantity,price);

                    String bill = "\n"+mhd+","+splitRow[0]+","+dateBill+","+kwQuantity+","+price+","+ foreign.totalMoney();
                    System.out.println(bill);
                    addBill.write(bill);
                }
            }
            else{
                break;
            }
        }
        bufferReader.close();
        addBill.flush();
        addBill.close();
    }
}
