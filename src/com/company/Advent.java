package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Advent {
    List<Integer> integersList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();
    public void countIncrease(){
        Integer increased = 0;
        Integer decreased = 0;
        integersList = TestUtils.readFileIntoListInteger("day1part1.txt");
        for(int i=0; i < integersList.size()-1; i++){
            if(integersList.get(i+1) > integersList.get(i)){
                increased++;
            }else if(integersList.get(i+1) < integersList.get(i)){
                decreased++;
            }
        }
        System.out.println("increased=" +increased);
        System.out.println("decreased=" +decreased);
    }

    public void sum3measurement(){
        Integer increased = 0;
        Integer decreased = 0;
        integersList = TestUtils.readFileIntoListInteger("day1part1.txt");
        for(int i=0; i< integersList.size()-3; i++){
            Integer sum1stWindow =  integersList.get(i) + integersList.get(i+1) + integersList.get(i+2);
            Integer sum2ndWindow = integersList.get(i+1) + integersList.get(i+2) + integersList.get(i+3);
            if(sum1stWindow < sum2ndWindow){
                increased++;
            }else if(sum2ndWindow < sum1stWindow){
                decreased++;
            }
        }
        System.out.println("increased=" +increased);
        System.out.println("decreased=" +decreased);
    }

    public void SubMovement(){
        stringList = TestUtils.readFileIntoList("day2part1.txt");
        Integer currentx = 0;
        Integer currenty = 0;
        for(int i=0; i< stringList.size(); i++){
            String line = stringList.get(i);
            if(line.startsWith("forward")){
                currentx += Integer.parseInt(line.substring(7).trim());
            }else if(line.startsWith("up")){
                currenty -= Integer.parseInt(line.substring(3));
            }else if(line.startsWith("down")){
                currenty += Integer.parseInt(line.substring(5));
            }
        }
        System.out.println("X="+currentx);
        System.out.println("Y="+currenty);
    }

    public void SubMovement2(){
        stringList = TestUtils.readFileIntoList("day2part1.txt");
        Integer currentx = 0;
        Integer currenty = 0;
        Integer currentaim = 0;
        for(int i=0; i< stringList.size(); i++){
            String line = stringList.get(i);
            if(line.startsWith("forward")){
                Integer forwardAmount = Integer.parseInt(line.substring(7).trim());
                currentx += forwardAmount;
                currenty += forwardAmount*currentaim;
            }else if(line.startsWith("up")){
                Integer upAmount = Integer.parseInt(line.substring(3));
                currentaim -= upAmount;
            }else if(line.startsWith("down")){
                currentaim += Integer.parseInt(line.substring(5));
            }
        }
        System.out.println("X="+currentx);
        System.out.println("Y="+currenty);
    }
}
