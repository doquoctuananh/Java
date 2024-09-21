package transports.service;

import transports.model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TransportsService {
    // tao cac loai hang san xuat voi du lieu co san
    public static Manufacturter typeManufacturter(String optionManufacturter) {
        ArrayList<Manufacturter> manufacturter = new ArrayList<>();
        Manufacturter manufacturter1 = new Manufacturter("1FA","Ford Motor Company","America");
        manufacturter.add(manufacturter1);
        Manufacturter manufacturter2 = new Manufacturter("JTN","Toyota Motor Corporation","Janpan");
        manufacturter.add(manufacturter2);
        Manufacturter manufacturter3 = new Manufacturter("WBA","BMW AG","Germany");
        manufacturter.add(manufacturter3);
        Manufacturter manufacturter4 = new Manufacturter("WDB","Mercedes-Benz","Germany");
        manufacturter.add(manufacturter4);
        Manufacturter manufacturter5 = new Manufacturter("KMH","Hyundai Motor Company","Korea");
        manufacturter.add(manufacturter5);

        Manufacturter manufacturterChoose  = new Manufacturter();

        for (int i = 0; i < manufacturter.size(); i++) {
            if(optionManufacturter.toUpperCase().equals(manufacturter.get(i).getCodeManufacturter())){

                manufacturterChoose.setCodeManufacturter(manufacturter.get(i).getCodeManufacturter());
                manufacturterChoose.setNameManufacturter(manufacturter.get(i).getNameManufacturter());
                manufacturterChoose.setCountry(manufacturter.get(i).getCountry());
                break;
            }
        }
        return manufacturterChoose;
    }


    //Scanner sc = new Scanner(System.in);
    // them phuong tien
    public static void createTransports(ArrayList<Transports> transports, String type){
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap bien kien soat");
        String numberPlate = sc.nextLine();

        System.out.println("Nhap ma san xuat cua hang xe ban chon : \n" +
                "1FA (Ford Motor Company) \n" +
                "JTN (Toyota Motor Corporation) \n" +
                "WBA (BMW AG) \n" +
                "WDB (Mercedes-Benz) \n" +
                "KMH (Hyundai Motor Company) \n");
        String optionManufacturter = sc.nextLine();
        //Manufacturter chooseManufacturter = TransportsService.typeManufacturter(optionManufacturter);

        System.out.println("nhap nam san xuat");
        int yearStart = Integer.parseInt(sc.nextLine());
        System.out.println("nhap chu so huu");
        String ownTransport = sc.nextLine();

        switch (type){
            case "Car":
                System.out.println("nhap so cho ngoi");
                int numberSeat = Integer.parseInt(sc.nextLine());
                System.out.println("nhap loai xe");
                String typeCar = sc.nextLine();
                Car car = new Car(numberPlate,ownTransport,yearStart,
                        TransportsService.typeManufacturter(optionManufacturter)
                        ,numberSeat,typeCar);

                transports.add(car);
                break;
            case "Motobike":
                System.out.println("nhap cong xuat");
                String capacity = sc.nextLine();
                Motobike motobike = new Motobike(numberPlate,ownTransport,yearStart,
                        TransportsService.typeManufacturter(optionManufacturter),
                        capacity);
                transports.add(motobike);
                break;
            case "Track":
                System.out.println("nhap trong tai");
                double playLoad = Double.parseDouble(sc.nextLine());
                Track track = new Track(numberPlate,ownTransport,yearStart,
                        TransportsService.typeManufacturter(optionManufacturter),
                        playLoad);
                transports.add(track);
                break;
        }
    }

    // hien thi phuong tien
    public static void getInformationTransport(ArrayList<Transports> transports){

                for (int i = 0; i < transports.size(); i++) {
                    System.out.println(transports.get(i).toString());
                }

    }

    // xoa phuong tien theo bien so xe
    public static void deleteTransportNumberPlate(ArrayList<Transports> cars,ArrayList<Transports> motobikes, ArrayList<Transports> tracks, String numberPlate){
        Scanner sc = new Scanner(System.in);
        int findIndexCar = -1;
        int findIndexMoto = -1;
        int findIndexTrack =-1;
        int findIndex = -1;
        for (int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getNumberPlate().equals(numberPlate)){
                findIndexCar = i;
                break;
            }
        }
        if(findIndexCar != -1){
            System.out.println("choose option delete\n" +
                    "1 Yes" +
                    "2. No\n");
            int chooseDelete = Integer.parseInt(sc.nextLine());
            switch (chooseDelete){
                case 1:
                    cars.remove(findIndexCar);
                    System.out.println("Delete numberplate Car succesful");
                    break;
                case 2:
                    findIndex++;
                    break;
            }

        }
        if(findIndexCar == -1){
            for (int i = 0; i < motobikes.size(); i++) {
                if(motobikes.get(i).getNumberPlate().equals(numberPlate)){
                    findIndexMoto=i;
                    break;
                }
            }
        }

        if(findIndexMoto != -1){
            System.out.println("choose option delete \n" +
                    "1 Yes \n" +
                    "2. No \n");
            int chooseDelete = Integer.parseInt(sc.nextLine());
            switch (chooseDelete){
                case 1:
                    cars.remove(findIndexMoto);
                    System.out.println("Delete numberplate Motobike succesful");
                    break;
                case 2:
                    findIndex++;
                    break;
            }

        }

        if(findIndexMoto == -1){
            for (int i = 0; i < tracks.size(); i++) {
                if(tracks.get(i).getNumberPlate().equals(numberPlate)){
                    findIndexTrack =i;
                    break;
                }
            }
        }

        if(findIndexTrack != -1){
            System.out.println("choose option delete\n" +
                    "1 Yes" +
                    "2. No\n");
            int chooseDelete = Integer.parseInt(sc.nextLine());
            switch (chooseDelete){
                case 1:
                    cars.remove(findIndexTrack);
                    System.out.println("Delete numberplate Track succesful");
                    break;
                case 2:
                    findIndex++;
                    break;
            }

        }

        // tim thay xe can delete va chon No
        if((findIndexMoto != -1 || findIndexCar !=-1 || findIndexTrack != -1) && findIndex != -1){

        }
        // khong tim thay xe delete
        else if(findIndexMoto != -1 || findIndexCar !=-1 || findIndexTrack != -1){

        }
        else if( findIndexTrack == -1){
            System.out.println("Not find numberplate");
        }
    }

    public static void findTransportNumberplate(ArrayList<Transports> cars,ArrayList<Transports> motobikes, ArrayList<Transports> tracks,String numberplate){
        ArrayList<Transports> newCars = new ArrayList<>();
        ArrayList<Transports> newMotos = new ArrayList<>();
        ArrayList<Transports> newTracks = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getNumberPlate().contains(numberplate)){
                newCars.add(cars.get(i));
            }
        }

        for (int i = 0; i < motobikes.size(); i++) {
            if(motobikes.get(i).getNumberPlate().contains(numberplate)){
                newMotos.add(motobikes.get(i));
            }
        }

        for (int i = 0; i < tracks.size(); i++) {
            if(tracks.get(i).getNumberPlate().contains(numberplate)){
                newTracks.add(tracks.get(i));
            }
        }

        if( newCars.isEmpty() && newMotos.isEmpty() && newTracks.isEmpty() ){
            System.out.println("Not find transport");
        }
        else{
            System.out.println("List Transport approximately Numberplate ");
            for (int i = 0; i < newCars.size(); i++) {
                System.out.println(newCars.get(i).toString());
            }
            for (int i = 0; i < newMotos.size(); i++) {
                System.out.println(newMotos.get(i).toString());
            }
            for (int i = 0; i < newTracks.size(); i++) {
                System.out.println(newTracks.get(i).toString());
            }
        }

    }

}



