package module2.ss17.io_binaryfile;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IOBinaryFile  {
    private static void copyBinaryFile(File source, File dest) throws IOException{
        InputStream io = new FileInputStream(source) ;
        BufferedReader dis = new BufferedReader(new InputStreamReader(io));

        OutputStream os = new FileOutputStream(dest);
        BufferedWriter dos = new BufferedWriter(new OutputStreamWriter(os));
        String line = dis.readLine();
        if(line != null ){
            dos.write(line);
            while((line = dis.readLine())!= null){
                dos.write("\n"+line);
            }
        }

        System.out.println("copy succesfully");
        dos.close();
        os.close();
        dis.close();
        io.close();
    }

    private static void createFile(File nameFile) {
        if(!nameFile.exists()){
            try{
                boolean created = nameFile.createNewFile();
                if(created){
                    System.out.println("Created file " + nameFile + " succesfully");
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static void writeFile(File source)  {
        try{
            OutputStream os = new FileOutputStream(source,true);
            DataOutputStream dos = new DataOutputStream(os);

            InputStream io = new FileInputStream(source) ;
            DataInputStream dis = new DataInputStream(io);

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            int i;
            if(source.length() >0){
                dos.writeBytes("\n"+line);
            }
            else{
                dos.writeBytes(line);
            }
            dis.close();
            io.close();
            dos.close();
            os.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        File source = new File("src/module2/ss17/io_binaryfile/source.dat");
        createFile(source);
        File dest = new File("src/module2/ss17/io_binaryfile/dest.dat");
        createFile(dest);
        System.out.println("Write source.dat");
        writeFile(source);
        System.out.println("copy source.dat to dest.dat");
        try{
            copyBinaryFile(source,dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
