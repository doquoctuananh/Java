package module2.case_study.service;

import module2.case_study.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

public class ServiceEmployee {
    //create folder
    public static void createFolder(File nameFolder){
        try{
            boolean check = nameFolder.exists();
            if(!check){
                boolean create = nameFolder.mkdir();
                if(create){
                    System.out.println("Create "+ nameFolder + " succesfully");
                }
            }
        } catch (SecurityException e){
            e.printStackTrace();
        }

    }

    // create file csv
    public static void createFile(File nameFile) {
        try{
            boolean check = nameFile.exists();
            if(!check){
                boolean created = nameFile.createNewFile();
                if(created){
                    System.out.println("Created "+ nameFile+" succesfully");
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //write certificate employee to File Certificate
    public static void writeCert(File namefile, String cert){
        try{
            boolean check = namefile.length()>0;

            if(check){
                FileWriter fileWriter = new FileWriter(namefile,true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n");
                bufferedWriter.write(cert);
                bufferedWriter.flush();
                fileWriter.close();
            }
            else{
                FileWriter fileWriter = new FileWriter(namefile);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(cert);
                bufferedWriter.flush();
                fileWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Enter certificate information employee
    public static String createCertificate(int setId){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter certificateId");
        String certId = sc.nextLine();
        System.out.println("Enter certificateName");
        String certName = sc.nextLine();
        System.out.println("Enter certificateRank");
        String certRank = sc.nextLine();
        System.out.println("Enter certificateDate");
        LocalDate certDate = LocalDate.parse(sc.nextLine());
        Certificate cert = new Certificate(certId,certName,certRank,certDate);
        String createCert = Integer.toString(setId)+","+cert.toString();
        return createCert;
    }

    //Enter employee Experience information
    public static String createExper(int setId, File certFile){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter fullname: ");
        String fullname = sc.nextLine();
        System.out.println("Enter birthday: " );
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println("Enter phone: ");
        double phone = Double.parseDouble(sc.nextLine());
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter year experience: ");
        int yearExper = Integer.parseInt(sc.nextLine());
        System.out.println("Enter pro skill");
        String skill = sc.nextLine();
        Experience.setCount(++setId);
        Experience exper = new Experience(Experience.getCount(),fullname,date,phone,email,yearExper,skill);

        boolean chooseCert = true;
        while(chooseCert){
            System.out.println("Enter certificate employee Experience \n" +
                    "1.Yes\n" +
                    "2. No");
            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:{
                    String createCert = createCertificate(Experience.getCount());
                    writeCert(certFile,createCert);
                    break;
                }
                case 2: chooseCert = false;
                break;
            }

        }
        return exper.toString();
    }

    //Enter employee Fresher information
    public static String createFresher(int setId, File certFIle){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter fullname: ");
        String fullname = sc.nextLine();
        System.out.println("Enter birthday: " );
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println("Enter phone: ");
        double phone = Double.parseDouble(sc.nextLine());
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter graduation date");
        LocalDate graduation_date = LocalDate.parse(sc.nextLine());
        System.out.println("Enter university name: ");
        String university_name = sc.nextLine();
        Fresher.setCount(++setId);
        Fresher fresher = new Fresher(Fresher.getCount(),fullname,date,phone,
                email,graduation_date,university_name);
        boolean choosecert = true;
        while(choosecert){
            System.out.println("Enter add certificate employee fresher: \n" +
                    "1.Yes\n" +
                    "2. No");
            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:{
                        String certFresher = createCertificate(Fresher.getCount());
                        writeCert(certFIle,certFresher);
                    break;
                }
                case 2:{
                    choosecert =false;
                    break;
                }

            }
        }

        return fresher.toString();
    }

    //Enter employee Intern information
    public static String createIntern(int setId, File certFile){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter fullname: ");
        String fullname = sc.nextLine();
        System.out.println("Enter birthday: " );
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println("Enter phone: ");
        double phone = Double.parseDouble(sc.nextLine());
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter " + fullname + " major");
        String major = sc.nextLine();
        System.out.println("Enter semester ");
        String semester = sc.nextLine();
        System.out.println("Enter university name ");
        String university_name = sc.nextLine();

        Intern.setCount(++setId);
        Intern intern = new Intern(Intern.getCount(),
                fullname,date,phone,email,major,semester,university_name);
        boolean choosecert = true;
        while(choosecert){
            System.out.println("Enter add certificate \n" +
                    "1. Yes\n" +
                    "2. No");
            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1: {
                    String certIntern = createCertificate(Intern.getCount());
                    writeCert(certFile,certIntern);
                    break;
                }
                case 2:{
                    choosecert = false;
                    break;
                }
            }
        }
        return intern.toString();
    }

    //wirite information employee to file
    public static void writeEmployeeFile(File namefile, File cert,
                                         BiFunction<Integer,File,String>createTypeEmplyee) throws IOException {
        boolean checkfile = namefile.length()>0;
        if(checkfile){
            FileReader reader = new FileReader(namefile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            String lastline= null;
            while((line= bufferedReader.readLine())!= null){
                lastline = line;
            }
            bufferedReader.close();
            reader.close();

            String[] splitgetId = lastline.split(",");
            String employee = createTypeEmplyee.apply(Integer.parseInt(splitgetId[0]),cert);
            FileWriter fileWriter = new FileWriter(namefile,true);

            BufferedWriter bufferedWriterExper= new BufferedWriter(fileWriter);
            bufferedWriterExper.write("\n");
            bufferedWriterExper.write(employee);
            bufferedWriterExper.flush();
            fileWriter.close();
        }
        else{
            String employee = createTypeEmplyee.apply(0,cert);
            FileWriter fileWriter = new FileWriter(namefile);
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
            bufferedWriter.write(employee);
            bufferedWriter.flush();
            fileWriter.close();
        }
    }

    // Add employee file
    public static void addEmployee(File fileExperience,File fileFresher, File fileIntern,
                                   File certExper, File certFresher, File certIntern) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose type employee: \n" +
                "1.Experience \n" +
                "2.Fresher \n" +
                "3.Intern");
        int option = Integer.parseInt(sc.nextLine());
        switch (option){
            case 1:
                System.out.println("Enter information employee Experience");
                writeEmployeeFile(fileExperience,certExper,ServiceEmployee::createExper);
                break;
            case 2:
                System.out.println("Enter information employee Fresher");
                writeEmployeeFile(fileFresher,certFresher,ServiceEmployee::createFresher);
                break;
            case 3:
                System.out.println("Enter information employee Intern");
                writeEmployeeFile(fileIntern,certIntern,ServiceEmployee::createIntern);
                break;
        }
    }

    // reader files employee
    public static ArrayList readFileEmployee(File nameFile){
        ArrayList<String> listEmployee = null;
        if(nameFile.length()>0){
            try{
                listEmployee = new ArrayList<>();
                FileReader fileReader = new FileReader(nameFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;
                while ((line = bufferedReader.readLine())!= null){
                    listEmployee.add(line);
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            return listEmployee;
        }

        return listEmployee;
    }

    // write file employee after update
    public static void writeFileEmployeeAfterUpdate(ArrayList<String> listEmployee, File nameFile){
        try{
            FileWriter fileWriter = new FileWriter(nameFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < listEmployee.size(); i++) {
                bufferedWriter.write(listEmployee.get(i));
                if(i<=listEmployee.size()-1){
                    bufferedWriter.write("\n");
                }
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // show information employee
    public static void showInformation(File fileExper, File fileFresher, File fileIntern){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose show information type employee\n" +
                "1. Show experience\n" +
                "2. Show Fresher\n" +
                "3. Show Intern"
                );
        int option = Integer.parseInt(sc.nextLine());
        switch (option){
            case 1:{
                ArrayList<String> list =readFileEmployee(fileExper);
                if(list == null){
                    System.out.println("File "+ fileExper.getName()+" isEmpty");
                }
                else{
                    for(String employee : list){
                        System.out.println(employee);
                    }
                }
                break;
            }
            case 2:{
                ArrayList<String> list =readFileEmployee(fileFresher);
                if(list == null){
                    System.out.println("File "+ fileExper.getName()+" isEmpty");
                }
                else{
                    for(String employee : list){
                        System.out.println(employee);
                    }
                }
                break;
            }
            case 3:{
                ArrayList<String> list =  readFileEmployee(fileIntern);
                if(list == null){
                    System.out.println("File "+ fileExper.getName()+" isEmpty");
                }
                else{
                    for(String employee : list){
                        System.out.println(employee);
                    }
                }
                break;
            }
            default:System.exit(0);
        }
    }

    //Update employee
    public static void updateEmployee(File fileExper, File fileFresher, File fileIntern){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type Employee need update Information\n" +
                "1.Experience\n" +
                "2.Fresher\n" +
                "3.Intern");
        int option = Integer.parseInt(sc.nextLine());
        switch (option){
            case 1:{
                ArrayList<String> list =readFileEmployee(fileExper);
                if(list == null){
                    System.out.println("File "+ fileExper.getName()+" isEmpty");
                }
                else{
                    System.out.println("Enter Id employee need update information");
                    int id = Integer.parseInt(sc.nextLine());
                    boolean findId = false;
                    for (int i = 0; i < list.size(); i++) {
                        String[] split = list.get(i).split(",");
                        if(Integer.parseInt(split[0]) == id){
                            System.out.println("Enter update fullname: ");
                            split[1]= sc.nextLine();
                            System.out.println("Enter update birthday: " );
                            split[2] = LocalDate.parse(sc.nextLine()).toString();
                            System.out.println("Enter update phone: ");
                            split[3] = Double.toString(Double.parseDouble(sc.nextLine())) ;
                            System.out.println("Enter update email: ");
                            split[4] = sc.nextLine();
                            System.out.println("Enter update year experience: ");
                            split[5] = Integer.toString(Integer.parseInt(sc.nextLine()));
                            System.out.println("Enter update pro skill");
                            split[6] = sc.nextLine();
                            String lineIndex = Integer.toString(id)+","+split[1]+","+split[2]+","+
                                    split[3]+","+split[4]+","+split[5]+","+split[6];
                            list.set(i,lineIndex);
                            findId = true;
                            break;
                        }
                    }
                    if(findId == true){
                        writeFileEmployeeAfterUpdate(list,fileExper);
                        System.out.println("Update information succesfully");
                    }
                    else{
                        System.out.println("Not find employee has id "+ id);
                    }
                }
                break;
            }
            case 2: {
                ArrayList<String> list =readFileEmployee(fileFresher);
                if(list == null){
                    System.out.println("File "+ fileExper.getName()+" isEmpty");
                }
                else{
                    System.out.println("Enter id employee need update information");
                    int id = Integer.parseInt(sc.nextLine());
                    boolean findFresher = false;
                    for (int i = 0; i < list.size(); i++) {
                        String[] split = list.get(i).split(",");
                        if(Integer.parseInt(split[0])== id){
                            System.out.println("Enter update fullname: ");
                            split[1]= sc.nextLine();
                            System.out.println("Enter update birthday: " );
                            split[2] = LocalDate.parse(sc.nextLine()).toString();
                            System.out.println("Enter update phone: ");
                            split[3] = Double.toString(Double.parseDouble(sc.nextLine())) ;
                            System.out.println("Enter update email: ");
                            split[4] = sc.nextLine();
                            System.out.println("Enter update Date graduation");
                            split[5] = LocalDate.parse(sc.nextLine()).toString();
                            System.out.println("Enter update Name University");
                            split[6] = sc.nextLine();
                            String lineIndex = Integer.toString(id)+","+split[1]+","+split[2]+","+
                                    split[3]+","+split[4]+","+split[5]+","+split[6]; ;
                            list.set(i,lineIndex);
                            findFresher = true;
                            break;
                        }
                    }
                    if(findFresher == true){
                        writeFileEmployeeAfterUpdate(list,fileFresher);
                        System.out.println("Update information succesfully");
                    }
                    else{
                        System.out.println("Not find employee has id "+ id);
                    }
                }
                break;
            }
            case 3 : {
                ArrayList<String> list =readFileEmployee(fileIntern);
                if(list == null){
                    System.out.println("File "+ fileExper.getName()+" isEmpty");
                }
                else{
                    System.out.println("Enter id employee need update information");
                    int id = Integer.parseInt(sc.nextLine());
                    boolean findIntern = false;
                    for (int i = 0; i < list.size(); i++) {
                        String[] split = list.get(i).split(",");
                        if (Integer.parseInt(split[0]) == id) {
                            System.out.println("Enter update fullname: ");
                            split[1] = sc.nextLine();
                            System.out.println("Enter update birthday: ");
                            split[2] = LocalDate.parse(sc.nextLine()).toString();
                            System.out.println("Enter update phone: ");
                            split[3] = Double.toString(Double.parseDouble(sc.nextLine()));
                            System.out.println("Enter update email: ");
                            split[4] = sc.nextLine();
                            System.out.println("Enter update major");
                            split[5] = sc.nextLine();
                            System.out.println("Enter update semester");
                            split[6] = sc.nextLine();
                            System.out.println("Enter update Name university");
                            split[7] = sc.nextLine();
                            String lineIndex = Integer.toString(id)+","+split[1]+","+split[2]+","+
                                    split[3]+","+split[4]+","+split[5]+","+split[6]+","+split[7];
                            list.set(i,lineIndex);
                            findIntern = true;
                            break;
                        }
                    }
                    if(findIntern == true){
                        writeFileEmployeeAfterUpdate(list,fileIntern);
                        System.out.println("Update information succesfully");
                    }
                    else{
                        System.out.println("Not find employee has id "+ id);
                    }
                }
                break;
            }
        }
    }

    // Tim kiem thong tin nhan vien theo ma id
    public static void searchEmployee(File fileExper, File fileFresher, File fileIntern){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type employee need search information\n" +
                "1.Employee Experience\n" +
                "2.Employee Fresher\n" +
                "3.EMployee Intern");
        int option = Integer.parseInt(sc.nextLine());
        switch (option){
            case 1 :{
                System.out.println("Enter id employee Experience need search");
                int id = Integer.parseInt(sc.nextLine());
                ArrayList<String> list = readFileEmployee(fileExper);
                boolean findEmployee = false;
                if(list == null){
                    System.out.println("File experience is Empty");
                }
                else{
                    for (int i = 0; i < list.size(); i++) {
                        String[] split = list.get(i).split(",");
                        if(Integer.parseInt(split[0])== id){
                            System.out.println("Information employee need search");
                            System.out.println(list.get(i));
                            findEmployee = true;
                            break;
                        }
                    }
                }
                if(findEmployee == false){
                    System.out.println("Not find Employee has id "+ id);
                }
                break;
            }
            case 2:{
                System.out.println("Enter id employee Fresher need search");
                int id = Integer.parseInt(sc.nextLine());
                ArrayList<String> list = readFileEmployee(fileFresher);
                boolean findEmployee = false;
                if(list == null){
                    System.out.println("File Fresher is Empty");
                }
                else{
                    for (int i = 0; i < list.size(); i++) {
                        String[] split = list.get(i).split(",");
                        if(Integer.parseInt(split[0])== id){
                            System.out.println("Information employee need search");
                            System.out.println(list.get(i));
                            findEmployee = true;
                            break;
                        }
                    }
                }
                if(findEmployee == false){
                    System.out.println("Not find Employee has id "+ id);
                }
                break;
            }
            case 3:{
                System.out.println("Enter id employee Intern need search");
                int id = Integer.parseInt(sc.nextLine());
                ArrayList<String> list = readFileEmployee(fileIntern);
                boolean findEmployee = false;
                if(list == null){
                    System.out.println("File Intern is Empty");
                }
                else{
                    for (int i = 0; i < list.size(); i++) {
                        String[] split = list.get(i).split(",");
                        if(Integer.parseInt(split[0])== id){
                            System.out.println("Information employee need search");
                            System.out.println(list.get(i));
                            findEmployee = true;
                            break;
                        }
                    }
                }
                if(findEmployee == false){
                    System.out.println("Not find Employee has id "+ id);
                }
                break;
            }
        }
    }

    // doc file gom nhieu certificate employee
    public static ArrayList readCertList(File certFile){
        ArrayList<String> list = null;
        if(certFile.length()>0){
            list = new ArrayList<>();
            try{
                FileReader fileReader = new FileReader(certFile);
                BufferedReader bufferedReader  = new BufferedReader(fileReader);
                String line = null;
                while((line = bufferedReader.readLine())!= null){
                    list.add(line);
                }
                return list;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return list;
    }

    // ghi list cert employee vao file certificate
    public static void writeCert(ArrayList<String> listCert,File certFile){
        try{
            FileWriter fileWriter = new FileWriter(certFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < listCert.size(); i++) {
                bufferedWriter.write(listCert.get(i));
                if(i<= listCert.size()-1){
                    bufferedWriter.write("\n");
                }
            }
            bufferedWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // xoa certificate cua nhan vien theo ma id cua nhan vien
    public static void deleteCertEmployeeId(int id,File certFile){
        ArrayList<String> list = readCertList(certFile);
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(",");
            if(Integer.parseInt(split[0])== id){
                list.remove(i);
                break;
            }
        }
        writeCert(list,certFile);
    }

    // xoa nhan vien theo ma id
    public static void deleteEMployeeId(File fileExper, File fileFresher, File fileIntern,
                                        File certExper,File certFresher, File certIntern){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type Employee need delete\n" +
                "1.Employee Experience\n" +
                "2.Employee Fresher\n" +
                "3.Employee Intern");
        int option = Integer.parseInt(sc.nextLine());
        switch (option){
            case 1:{
                System.out.println("Enter id employee Experience need Delete");
                int id = Integer.parseInt(sc.nextLine());
                ArrayList<String> list = readFileEmployee(fileExper);
                boolean findEmployee = false;
                if(list == null){
                    System.out.println("File experience id Empty");
                }
                else{

                    for (int i = 0; i < list.size(); i++) {
                        String[] split = list.get(i).split(",");
                        if(Integer.parseInt(split[0]) == id){
                            list.remove(i);
                            deleteCertEmployeeId(id,certExper);
                            findEmployee = true;
                            break;
                        }
                    }
                    writeFileEmployeeAfterUpdate(list,fileExper);
                }
                if(findEmployee == true){
                    System.out.println("Delete employee experience has id "+ id+ " succesfully");
                }
                else{
                    System.out.println("Not find employee has id "+ id);
                }
                break;
            }
            case 2:{
                System.out.println("Enter id employee Fresher need Delete");
                int id = Integer.parseInt(sc.nextLine());
                ArrayList<String> list = readFileEmployee(fileFresher);
                boolean findEmployee = false;
                if(list == null){
                    System.out.println("File Fresher id Empty");
                }
                else{

                    for (int i = 0; i < list.size(); i++) {
                        String[] split = list.get(i).split(",");
                        if(Integer.parseInt(split[0]) == id){
                            list.remove(i);
                            deleteCertEmployeeId(id,certFresher);
                            findEmployee = true;
                            break;
                        }
                    }
                    writeFileEmployeeAfterUpdate(list,fileFresher);
                }
                if(findEmployee == true){
                    System.out.println("Delete employee fresher has id "+ id+ " succesfully");
                }
                else{
                    System.out.println("Not find employee has id "+ id);
                }
                break;
            }
            case 3:{
                System.out.println("Enter id employee Intern need Delete");
                int id = Integer.parseInt(sc.nextLine());
                ArrayList<String> list = readFileEmployee(fileIntern);
                boolean findEmployee = false;
                if(list == null){
                    System.out.println("File Intern id Empty");
                }
                else{

                    for (int i = 0; i < list.size(); i++) {
                        String[] split = list.get(i).split(",");
                        if(Integer.parseInt(split[0]) == id){
                            list.remove(i);
                            deleteCertEmployeeId(id,certIntern);
                            findEmployee = true;
                            break;
                        }
                    }
                    writeFileEmployeeAfterUpdate(list,fileIntern);
                }
                if(findEmployee == true){
                    System.out.println("Delete employee Intern has id "+ id+ " succesfully");
                }
                else{
                    System.out.println("Not find employee has id "+ id);
                }
                break;
            }
        }
    }
}
