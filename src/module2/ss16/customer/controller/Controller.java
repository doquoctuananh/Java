package module2.ss16.customer.controller;

import module2.ss16.customer.model.Customer;
import module2.ss16.customer.service.Service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File parentFile = new File("E:\\Back-End Java CodeGym\\Exercise\\Java\\src\\module2\\ss16\\customer","FileCustomer");
        if(!parentFile.exists()){
            parentFile.mkdir();
        }
        File customers = new File(parentFile,"customer.txt");
        if(!customers.exists()){
            try{
                boolean created = customers.createNewFile();
                if(created){
                    System.out.println("Create customer.txt succesfully");
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        while(1>0){
            System.out.println("Menu \n" +
                    "1.Add\n" +
                    "2.Show information\n" +
                    "3.Delete by Id\n" +
                    "4.Update By Id\n" +
                    "5. Exit");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    try(
                        FileReader fileReader = new FileReader(customers)
                    ){
                        try{
                            String absolute =  customers.getAbsolutePath();;
                            Service.addCustomer(absolute,fileReader);
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    try(FileReader fileReader = new FileReader(customers)){
                        try{
                            Service.showInformation(fileReader);
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    try(FileReader fileReader = new FileReader(customers)){
                        try{
                            String absolute = customers.getAbsolutePath();
                            Service.deleteCustomerId(fileReader,absolute);
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 4:
                    try(FileReader fileReader = new FileReader(customers)){
                        try{
                            String absolute = customers.getAbsolutePath();
                            Service.updateCustomer(fileReader,absolute);
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
