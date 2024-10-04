package module2.manage_customer_arraylist.controller;

import module2.manage_customer_arraylist.model.Customer;
import module2.manage_customer_arraylist.service.ManageService;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();

        while(1>0){
            System.out.println("Enter choose: \n" +
                    "1.Add Customer \n" +
                    "2.Show all information\n" +
                    "3.Delete customer\n" +
                    "4.Update customer\n");
            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:
                    ManageService.addCustomer(customers);
                    break;
                case 2:
                    ManageService.showInformation(customers);
                    break;
                case 3:
                    System.out.println("Enter id need delete customer");
                    int id = Integer.parseInt(sc.nextLine());
                    ManageService.deleteCustomerId(customers,id);
                    break;
                case 4:
                    System.out.println("Enter id need update customer:");
                    int _id = Integer.parseInt(sc.nextLine());
                    ManageService.updateCustomerId(customers,_id);
                    break;
            }
        }
    }
}
