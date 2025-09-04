package org.example;

import java.text.CollationElementIterator;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static double getresult(List<Integer> data) {
//        if(data.size()!=0){
            Collections.sort(data);
            Map<Integer,Integer> frq=new HashMap<>();
            for(int i =0;i<data.size();i++){
                frq.put(data.get(i),frq.getOrDefault(data.get(i),0)+1);
            }
            List<Map.Entry<Integer, Integer> > list =
                    new LinkedList<Map.Entry<Integer, Integer> >(frq.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
                public int compare(Map.Entry<Integer, Integer> o1,
                                   Map.Entry<Integer, Integer> o2) {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });
            return Double.NaN;
//        }
//        return Double.NaN;
    }
    public static void main(String[] args) {
    List<Integer> data = new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8,9,9,9,10,10));
//        List<Map.Entry<Integer, Integer>>
//    f=getresult(data);
//        for(Map.Entry<Integer, Integer> e:f){
//            System.out.println(e.getKey()+":"+e.getValue());
//        }
    }
}