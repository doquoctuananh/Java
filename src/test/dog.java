package test;

import java.util.ArrayList;


public class dog  {
    public static void main(String[] args) {
        ArrayList <String> list = new ArrayList<>();
        list.add("37c5646");
        list.add("81c");
        list.add("37f");
        list.add("85h");
        ArrayList <String> newList = new ArrayList<>();
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).contains("c") ){
                newList.add(list.get(i));
            }
        }

        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }
    }
    }


