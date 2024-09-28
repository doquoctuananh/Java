package test;

import java.io.*;
import java.util.*;


public class dog   {
    public static void main(String[] args) {
        Map<Integer, Integer> mymap = new HashMap<>();
        mymap.put(100,10);
        mymap.put(3,15);
        mymap.put(8,11);
        mymap.put(2,11);
        System.out.println(mymap.entrySet());
        for (Map.Entry<Integer,Integer> entry : mymap.entrySet()){
            System.out.println("key "+ entry.getKey() + " value "+ entry.getValue());
        }
    }

}


