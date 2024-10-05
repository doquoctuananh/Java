package module2.ss16.file;

import java.io.*;
import java.util.Scanner;

public class CopyFile {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File text = new File("text.txt");
        File copytext = new File("copytext.txt");
        if(!text.exists()){
            boolean created = text.createNewFile();
            if(created){
                System.out.println("Succesfully file ");
            }
        }
        if(!copytext.exists()){
            boolean created = copytext.createNewFile();
            if(created){
                System.out.println("Succesfully file ");
            }
        }
        //ghi noi dung len file text.txt
        System.out.println("Write information on text.txt: ");
        try{
            String string = sc.nextLine();
            FileWriter write = new FileWriter(text,true);
            FileReader readertext = new FileReader(text);
            BufferedReader readertextBuffer = new BufferedReader(readertext);
            if(readertextBuffer.readLine() != null){
                write.write("\n"+ string);
            }
            else{
                write.write(string);
            }
            write.flush();
            write.close();
            readertextBuffer.close();
            readertext.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("You write on text.txt done");
        // copy noi dung text.txt sang copytext.txt
        System.out.println("System copy content text.txt to copytext.txt");
        try{
            FileWriter copy = new FileWriter(copytext);
            FileReader reader = new FileReader(text);
            BufferedReader readerBuffer = new BufferedReader(reader);
            String readerText = null;

                while((readerText = readerBuffer.readLine())!= null){
                    copy.write(readerText);
                    copy.write("\n");
                }
            copy.flush();
            copy.close();
            readerBuffer.close();
            reader.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Copy succesfully");
    }
    }

