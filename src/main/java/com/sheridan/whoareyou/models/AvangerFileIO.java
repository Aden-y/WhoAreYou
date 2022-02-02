package com.sheridan.whoareyou.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AvangerFileIO{
    public static List<Avanger> loadAvangers(String filePath) throws FileNotFoundException {
        List<Avanger> list = new ArrayList();
        Scanner sc = new Scanner(new File(filePath));
        boolean first = true;
        while(sc.hasNextLine()) {
            if(first) {
                first = false;
            }else {
                String []line = sc.nextLine().trim().split(",");
                try {
                    String name = line[0];
                    boolean canFly = Boolean.parseBoolean(line[1]);
                    int intelligence = Integer.parseInt(line[2]);
                    int strength = Integer.parseInt(line[3]);
                    int speed = Integer.parseInt(line[4]);
                    int energy = Integer.parseInt(line[5]);
                    int skill = Integer.parseInt(line[6]);
                    int leadership = Integer.parseInt(line[7]);
                    int charm = Integer.parseInt(line[8]);
                    int luck = Integer.parseInt(line[9]);
                    String  detailUrl = line[10],imageUrl = line[11];
                    list.add(new Avanger(name, canFly, intelligence, strength, speed, energy, skill, leadership, charm, luck, detailUrl, imageUrl ));
                }catch(Exception ex) {}
            }
        }
        return list;
    }
    
    public static Avanger findSimilar(Avanger a, List<Avanger> list) {
        List<Double> similarities = new ArrayList();
        for(Avanger a1: list) {
            similarities.add(a.getSimilarity(a1));
        }
        return list.get(similarities.indexOf(Collections.max(similarities)));
    }
}
