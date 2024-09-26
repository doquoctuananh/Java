package ss13.controller;

import ss13.model.Product;
import ss13.service.ProductManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(1>0){
            System.out.println("Menu: \n" +
                    "1 add\n" +
                    "2 update with Id\n" +
                    "3 delete with id\n" +
                    "4 show all \n" +
                    "5 search product name \n" +
                    "6 arrange product price \n" +
                    "7 Exit");
            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:
                    ProductManager.addProduct(products);
                    break;
                case 2:
                    ProductManager.updateProduct(products);
                    break;
                case 3:
                    ProductManager.deleteProductId(products);
                    break;
                case 4:
                    ProductManager.getInfo(products);
                    break;
                case 5:
                    ProductManager.searchProductName(products);
                    break;
                case 6:
                    ProductManager.arrangeProductPrice(products);
                    break;
                case 7:
                    System.exit(0);

            }
        }
    }
}
