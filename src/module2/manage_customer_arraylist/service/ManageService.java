package module2.manage_customer_arraylist.service;

import module2.manage_customer_arraylist.model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageService {

    //them khach hang
    public static void addCustomer(ArrayList<Customer> customers){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter information customer: ");
        System.out.println("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter birthday: ");
        LocalDate birthday = LocalDate.parse(sc.nextLine());
        System.out.println("Enter address: ");
        String address = sc.nextLine();

        Customer customer = new Customer(id,name,birthday,address);
        customers.add(customer);

    }

    // hien thi thong tin khach hang
    public static void showInformation(ArrayList<Customer> customers){
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).toString());
        }
    }

    // xoa thong tin khach hang
    public static void deleteCustomerId(ArrayList<Customer> customers, int id){
        int findIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id){
                findIndex++;
                customers.remove(i);
                break;
            }
        }
        if(findIndex ==-1){
            System.out.println("Not find Id delete");
        }
    }

    // cap nhat thong tin khach hang
    public static void updateCustomerId(ArrayList<Customer> customers,int id){
        Scanner sc = new Scanner(System.in);
        int findIndex = -1;

        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id){

                System.out.println("Enter update id: ");
                int newId = Integer.parseInt(sc.nextLine());
                System.out.println("Enter update name: ");
                String newName = sc.nextLine();
                System.out.println("Enter update birthday: ");
                LocalDate newLocaldate = LocalDate.parse(sc.nextLine());
                System.out.println("Enter update address: ");
                String newAddress = sc.nextLine();

                Customer updateCustomer = new Customer(newId,newName,newLocaldate,newAddress);

                customers.set(i,updateCustomer);
                findIndex++;
                break;
            }
        }

        if(findIndex == -1){
            System.out.println("No find Id update");
        }
    }


}
