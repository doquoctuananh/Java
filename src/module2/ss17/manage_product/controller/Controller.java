package module2.ss17.manage_product.controller;

import module2.ss17.manage_product.service.Manager_Product;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File product = new File("src/module2/ss17/manage_product/product.csv");
        Manager_Product.createdFile(product);
        while(1>0){
            System.out.println("Menu: \n" +
                    "1. Add Product in file\n" +
                    "2. Show product\n" +
                    "3. Search Product\n" +
                    "4. Exit");
            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:
                    Manager_Product.addProductFile(product);
                    break;
                case 2:
                    Manager_Product.showProductFile(product);
                    break;
                case 3:
                    Manager_Product.searchProduct(product);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
