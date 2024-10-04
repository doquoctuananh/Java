package module2.ss13.service;

import module2.ss13.model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    // them san pham
    public static void addProduct(ArrayList<Product> Products){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter name product: ");
        String name = sc.nextLine();
        System.out.println("Enter price: ");
        float price = Float.parseFloat(sc.nextLine());

        Product product = new Product(id,name,price);
        Products.add(product);
    }
    // cap nhat lai san pham theo id
    public static void updateProduct(ArrayList<Product> Products){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id need Update product");
        int id = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < Products.size(); i++) {
            if(Products.get(i).getId() == id){
                System.out.println("Enter name update product: ");
                String name = sc.nextLine();
                System.out.println("Enter update price: ");
                float price = Float.parseFloat(sc.nextLine());

                Products.get(i).setName(name);
                Products.get(i).setPrice(price);
                break;
            }
        }
    }
    // xoa san pham theo id
    public  static void deleteProductId(ArrayList<Product> Products){
        System.out.println("Enter id product delete");
        Scanner sc = new Scanner(System.in);
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < Products.size(); i++) {
            if(Products.get(i).getId() == id){
                Products.remove(i);
                break;
            }
        }
    }

    // hien thi san pham
    public  static void getInfo(ArrayList<Product> Products){

        for (int i = 0; i < Products.size(); i++) {
            System.out.println(Products.get(i));
        }
    }

    // tiem kiem san pham theo ten
    public  static void searchProductId(ArrayList<Product> Products){
        System.out.println("Enter id product search");
        Scanner sc = new Scanner(System.in);
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < Products.size(); i++) {
            if(Products.get(i).getId() == id){
                System.out.println(Products.get(i));
                break;
            }
        }
    }

    // tim kiem theo ten
    public  static void searchProductName(ArrayList<Product> Products){
        System.out.println("Enter name product search");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (int i = 0; i < Products.size(); i++) {
            if(Products.get(i).getName().contains(name)){
                System.out.println(Products.get(i));
            }
        }
    }

    // sap xep san pham theo gia thu tu tang dan
    public  static void arrangeProductPrice(ArrayList<Product> Products){

        for (int i = 0; i < Products.size()-1; i++) {
            for (int j = i+1; j <Products.size(); j++) {
                if(Products.get(i).getPrice()>Products.get(j).getPrice()){
                    int id  = Products.get(i).getId();
                    Products.get(i).setId(Products.get(j).getId());
                    Products.get(j).setId(id);

                    String name = Products.get(i).getName();
                    Products.get(i).setName(Products.get(j).getName());
                    Products.get(j).setName(name);

                    float temp = Products.get(i).getPrice();
                    Products.get(i).setPrice(Products.get(j).getPrice());
                    Products.get(j).setPrice(temp);
                }
            }
        }

        for (int i = 0; i < Products.size(); i++) {
            System.out.println(Products.get(i));
        }
    }

}
