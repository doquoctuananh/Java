package module2.ss16.customer.service;

import module2.ss16.customer.model.Customer;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    // them khach hang
    public static void addCustomer(String absolute,FileReader fileReader) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter birthday: ");
        LocalDate birthday = LocalDate.parse(sc.nextLine());
        System.out.println("Enter address: ");
        String address = sc.nextLine();

        BufferedReader bufferReader = new BufferedReader(fileReader);
        String line = null;
        String getLastLine= null;
        line =bufferReader.readLine();
        if(line == null){
            FileWriter fileWriter = new FileWriter(absolute);
            Customer customer = new Customer(name,birthday,address);
            fileWriter.write(customer.toString());
            fileWriter.close();
        }
        else {
            getLastLine = line;
            while((line = bufferReader.readLine())!= null){
                getLastLine = line;
            }
            String[] splitLine = getLastLine.split(",");
            int getLastId = Integer.parseInt(splitLine[0]);
            Customer.setCount(++getLastId);
            Customer customer = new Customer(name,birthday,address);
            FileWriter fileWriter = new FileWriter(absolute,true);
            fileWriter.write("\n"+customer.toString());
            fileWriter.flush();
            fileWriter.close();
        }
        bufferReader.close();
        fileReader.close();
    }

    // hien thi khach hang
    public static void showInformation(FileReader fileCustomer) throws IOException{
        BufferedReader buffer = new BufferedReader(fileCustomer);
        String line = null;
        while((line = buffer.readLine())!= null){
            System.out.println(line);
        }
        buffer.close();
        fileCustomer.close();
    }

    // xoa thong tin khach hang
    public static void deleteCustomerId(FileReader readerCustomer, String absolute) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id Customer delete: ");
        int id = Integer.parseInt(sc.nextLine());
        ArrayList listCustomer = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(readerCustomer);
        String line = null;
        while((line = buffer.readLine())!= null){
            listCustomer.add(line);
        }

        for (int i = 0; i < listCustomer.size(); i++) {
            String[] arrayId = listCustomer.get(i).toString().split(",");
            if(Integer.parseInt(arrayId[0]) == id){
                listCustomer.remove(i);
                break;
            }
        }
        //boolean append = false;
        FileWriter fileWriter = new FileWriter(absolute);
        BufferedWriter bufferWrite = new BufferedWriter(fileWriter);
        for (int i = 0; i < listCustomer.size(); i++) {
            bufferWrite.write(listCustomer.get(i).toString());
            if(i< listCustomer.size()-1){
                bufferWrite.newLine();
            }
        }
        bufferWrite.flush();
        bufferWrite.close();
        buffer.close();
        readerCustomer.close();
        fileWriter.close();
    }

    // cap nhat thong tin khach hang
    public static void updateCustomer(FileReader fileReader,String absolute) throws IOException{
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listCustomer = new ArrayList<>();
        int findCusotmer = -1;
        System.out.println("Enter Id need update: ");
        int id = Integer.parseInt(sc.nextLine());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;

        while ((line = bufferedReader.readLine())!= null){
            String[] split = line.split(",");
            if(Integer.parseInt(split[0]) == id){
                findCusotmer ++;
                System.out.println("Update name: ");
                split[1] = sc.nextLine();
                System.out.println("Enter birthday" );
                LocalDate birthday = LocalDate.parse(sc.nextLine());
                split[2] = birthday.toString();
                System.out.println("update address");
                split[3] = sc.nextLine();
                String merge = String.join(",",split);
                listCustomer.add(merge);
                continue;
            }
            listCustomer.add(line);
        }

        if(findCusotmer == -1){
            System.out.println("Not find custome with id : " + id);
        }
        else{
            FileWriter fileWriter = new FileWriter(absolute);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < listCustomer.size(); i++) {
                bufferedWriter.write(listCustomer.get(i));
                if(i< listCustomer.size()-1){
                    bufferedWriter.newLine();
                }
            }
            System.out.println("update succesfully");
            bufferedWriter.close();
            fileWriter.close();
        }
        bufferedReader.close();
        fileReader.close();
    }
}
