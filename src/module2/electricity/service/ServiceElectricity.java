package module2.electricity.service;

import module2.electricity.model.Foreign;
import module2.electricity.model.Person;
import module2.electricity.model.Vietnamese;

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

                if(idPerson.toUpperCase().contains("KHVN")){
                    Person.count++;
                    Person.updateIdBill();
                    String mhd = Person.idBill;
                    Vietnamese vn = new Vietnamese(mhd,splitRow[0],dateBill,kwQuantity,price);
                    vn.setLimitConsume(Integer.parseInt(splitRow[3]));
                    String bill = "\n"+mhd+","+splitRow[0]+","+dateBill+","+kwQuantity+","+price+","+ vn.totalMoney();
                    System.out.println(bill);
                    addBill.write(bill);
                    break;
                }
                else if(idPerson.toUpperCase().contains("KHNN")){
                    Person.count++;
                    Person.updateIdBill();
                    String mhd = Person.idBill;
                    Foreign foreign = new Foreign(mhd,splitRow[0],dateBill,kwQuantity,price);
                    String bill = "\n"+mhd+","+splitRow[0]+","+dateBill+","+kwQuantity+","+price+","+ foreign.totalMoney();
                    System.out.println(bill);
                    addBill.write(bill);
                    break;
                }
            }
        }
        bufferReader.close();
        addBill.flush();
        addBill.close();
    }

    // chuc nang chinh sua hoa don
    public static void updateBill(FileReader bill,FileReader customer) throws  IOException{
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lineStringBill = new ArrayList<>();
        System.out.println("Enter code bill need update");
        String codeBill = sc.nextLine();
        String readBill = null;
        BufferedReader bufferedReaderBill = new BufferedReader(bill);

        boolean findCusomer = false;
        boolean findbill = false ;
        //doc file hoadon den ma hoa don can doi
        while((readBill = bufferedReaderBill.readLine())!=null){

            String[] readlineBill = readBill.split(",");
            if(readlineBill[0].toUpperCase().equals(codeBill.toUpperCase())){
                findbill = true;
                System.out.println("Enter update new code Customer ");
                String changeCodeCustomer = sc.nextLine();
                BufferedReader bufferReaderCustomer = new BufferedReader(customer);
                String reader = null;

                // doc file khach hang coi co ton tai khach hang can update
                while((reader = bufferReaderCustomer.readLine())!= null){
                    String[] readerLineCustomer = reader.split(",");
                    // neu ma khach hang co ton tai
                    if(readerLineCustomer[0].toUpperCase().equals(changeCodeCustomer.toUpperCase())){
                        findCusomer = true;
                        if(changeCodeCustomer.toUpperCase().contains("KHVN")){

                            readlineBill[1] = changeCodeCustomer.toUpperCase();

                            System.out.println("Enter date out bill update");
                            LocalDate dateBillUpdate = LocalDate.parse(sc.nextLine());
                            readlineBill[2]=dateBillUpdate.toString();

                            System.out.println("Enter Kw quatity update");
                            int kwQuantityUpdate = Integer.parseInt(sc.nextLine());
                            readlineBill[3]=Integer.toString(kwQuantityUpdate);

                            System.out.println("Enter Price update");
                            float priceUpdate = Float.parseFloat(sc.nextLine());
                            readlineBill[4]=Float.toString(priceUpdate);

                            Vietnamese vn = new Vietnamese(readlineBill[0],changeCodeCustomer,
                                    dateBillUpdate, kwQuantityUpdate,priceUpdate  );
                            readlineBill[5]=Double.toString(vn.totalMoney());

                            lineStringBill.add(String.join(",",readlineBill));
                            break;
                            //bufferReaderCustomer.close();

                        }
                        else if(changeCodeCustomer.toUpperCase().contains("KHNN")){

                            readlineBill[1] = changeCodeCustomer.toUpperCase();

                            System.out.println("Enter date out bill update");
                            LocalDate dateBillUpdate = LocalDate.parse(sc.nextLine());
                            readlineBill[2]=dateBillUpdate.toString();

                            System.out.println("Enter Kw quatity update");
                            int kwQuantityUpdate = Integer.parseInt(sc.nextLine());
                            readlineBill[3]=Integer.toString(kwQuantityUpdate);

                            System.out.println("Enter Price update");
                            float priceUpdate = Float.parseFloat(sc.nextLine());
                            readlineBill[4]=Float.toString(priceUpdate);

                            Foreign vn = new Foreign(readlineBill[0],changeCodeCustomer,
                                    dateBillUpdate, kwQuantityUpdate,priceUpdate  );
                            readlineBill[5]=Double.toString(vn.totalMoney());

                            lineStringBill.add(String.join(",",readlineBill));
                            break;
                        }
                    }
                }
                bufferReaderCustomer.close();

            }
            if(!findbill){
                lineStringBill.add(readBill);
            }

        }
        if(findCusomer){
            FileWriter updateBill = new FileWriter("E:/Back-End Java CodeGym/Exercise/Java/Electricity_Customer/hoadon.csv");
            for(String line : lineStringBill) {
                updateBill.write(line+"\n");
            }
            updateBill.close();
        }
        else{
            System.out.println("update fail");
        }
        bufferedReaderBill.close();

    }

    // hien thi chi tiet hoa don
    public static void showDetailBill(FileReader bill, FileReader customer) throws  Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id bill : ");
        String idBill = sc.nextLine();
        boolean findBill = false;
        //ArrayList<String> showDetailBill = new ArrayList<>();
        BufferedReader readerBill = new BufferedReader(bill);
        String lineBill = null;
        while((lineBill = readerBill.readLine())!= null){
            String [] arrLineBill = lineBill.split(",");
            if(arrLineBill[0].toUpperCase().equals(idBill.toUpperCase())){
                findBill = true;
                BufferedReader readerCustomer = new BufferedReader(customer);
                String lineCustomer = null;
                while((lineCustomer = readerCustomer.readLine())!= null){
                    String [] arrLineCustomer = lineCustomer.split(",");
                    if(arrLineBill[1].toUpperCase().equals(arrLineCustomer[0])){
                        arrLineBill[1] = arrLineCustomer[1];
                        System.out.println("Detail bill :  "+ arrLineBill[0] + " "+ arrLineBill[1]+ " " +  arrLineBill[2]+ " "
                        + arrLineBill[3]+ " " +arrLineBill[4]+ " " + arrLineBill[5]
                        );
                        break;
                    }
                }
                readerCustomer.close();
                break;
            }
        }
        if(!findBill){
            System.out.println("Not find id bill");
        }
        readerBill.close();
    }


}
