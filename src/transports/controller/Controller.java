package transports.controller;

import transports.model.Car;
import transports.model.Transports;
import transports.service.TransportsService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        ArrayList <Transports> cars = new ArrayList<>();
        ArrayList<Transports> motobikes = new ArrayList<>();
        ArrayList<Transports> tracks = new ArrayList<>();


        Scanner sc = new Scanner(System.in);
        while(1>0){
            System.out.println("nhap tuy chon \n"+
                    "1. them phuong tien: \n" +
                    "2. hien thi phuong tien \n" +
                    "3. Xoa phuong tien theo bien so \n" +
                    "4. Tim kiem theo bien so xe \n" +
                    "5.thoat"
            );

            int option = Integer.parseInt(sc.nextLine());

            switch (option){
                case 1: {
                    System.out.println("phuong tien ban muon them \n" +
                            "1.Car \n" +
                            "2.Motobike \n" +
                            "3.Track \n");
                    int optionTransport = Integer.parseInt(sc.nextLine());

                    if(optionTransport ==1){
                        TransportsService.createTransports(cars,"Car");
                    }
                    else if(optionTransport ==2){
                        TransportsService.createTransports(motobikes,"Motobike");
                    } else if (optionTransport ==3) {
                        TransportsService.createTransports(tracks,"Track");
                    }
                    break;
                    }

                case 2:
                    System.out.println("hien thi phuong tien ban muon\n" +
                            "1.Car \n" +
                            "2.Motobike \n" +
                            "3.Track \n");
                    int optionShow = Integer.parseInt(sc.nextLine());

                    if(optionShow == 1){
                            TransportsService.getInformationTransport(cars);
                    }
                    else if(optionShow ==2){
                        TransportsService.getInformationTransport(motobikes);
                    }
                    else {
                        TransportsService.getInformationTransport(tracks);
                    }
                    break;

                case 3:
                    System.out.println("Enter delete numberPlate: ");
                    String deleteNumberplate = sc.nextLine();
                    TransportsService.deleteTransportNumberPlate(cars,motobikes,tracks,deleteNumberplate);
                    break;
                case 4:
                    System.out.println("Enter find numberplate: ");
                    String findNumberplate = sc.nextLine();
                    TransportsService.findTransportNumberplate(cars,motobikes,tracks,findNumberplate);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }


}
