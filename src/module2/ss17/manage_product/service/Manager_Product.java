package module2.ss17.manage_product.service;

import module2.ss17.manage_product.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Manager_Product {
    // tao file
    public static void createdFile(File nameFile){
        if(!nameFile.exists()){
            try{
                boolean created = nameFile.createNewFile();
                if(created){
                    System.out.println("created file "+ nameFile +"succesfully");
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    // ghi san pham len file
    public static void writeProductFile(File namefile,Product product) throws IOException{
        OutputStream os = new FileOutputStream(namefile,true);
        BufferedWriter bufferedWriter = new BufferedWriter
                (new OutputStreamWriter(os));

        InputStream io = new FileInputStream(namefile);
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(io));
        String line = null;
        String getLastLine = null;
        line = bufferedReader.readLine();

        if(line == null){
            bufferedWriter.write(product.toString());
        }
        else{
            getLastLine = line;
            while((line = bufferedReader.readLine())!= null){
                getLastLine = line;
            }
            String[] split = getLastLine.split(",");
            int splitId = Integer.parseInt(split[0]);
            Product.setCount(++splitId);
            product.setId(Product.getCount());
            bufferedWriter.write("\n"+ product.toString());
        }
        bufferedWriter.close();
        os.close();
    }

    // them san pham vao file
    public static void addProductFile(File nameFile){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name product ");
        String name = sc.nextLine();
        System.out.println("Enter price ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Enter Manufacture ");
        String manufacture = sc.nextLine();
        System.out.println("Enter description: ");
        String description = sc.nextLine();
        Product product = new Product
                (name,price,manufacture,description);
        try{
            writeProductFile(nameFile,product);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    // hien thi san pham
    public static void showProductFile(File nameFile){
        try{
            InputStream os = new FileInputStream(nameFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(os));
            String line = null;
            while((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
            bufferedReader.close();
            os.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }


    // tim kiem san pham
    public static void searchProduct(File nameFile){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id product need search");
        int id = Integer.parseInt(sc.nextLine());
        boolean find = false;
        try{
            InputStream os = new FileInputStream(nameFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(os));
            String line = null;
            while((line= bufferedReader.readLine())!= null){
                String[] split = line.split(",");
                if(id == Integer.parseInt(split[0])){
                    find = true;
                    System.out.println("Information Product need search ");
                    System.out.println(line);
                    break;
                }
            }
            if(find ==false){
                System.out.println("Not find Product in " + nameFile);
            }
            bufferedReader.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
