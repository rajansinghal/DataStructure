package com.practice.program.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        callType(10);

        List<Integer> list = new ArrayList<>();
        list.add(2007);
        list.add(2008);
        list.add(2009);
        System.out.println(list);
        for (int i : list){
            int index = list.indexOf(i);
            list.set(index, ++i);
        }
        System.out.println(list);

      /* genericMethod("abc");
       genericMethod(1);*/

       /* Map<Integer, String> map = new HashMap<>();
       map.put(1,"1");
       map.put(2,"2")
               ;
       map.put(null, "3");
       map.put(1,"4");
       for(int i : map.keySet()) {
           System.out.println(i);
           System.out.println(map.get(i));
       }*/
       /*List vit = new ArrayList();
       vit.add("a");
       vit.add("b12");
       vit.add("c");
       vit.set(1,"b");
       vit.add(1,"d");
        System.out.println(vit);*/


    }

    private static void callType(Number num){
        System.out.println("1");


    }

    private  static void callType(Object obj){
        System.out.println("2");
    }



  /*  static<T> void genericMethod(T t){
        overloadedMethod(t);
    }

    static void overloadedMethod(Object o){
        System.out.println("obj");
    }

    static void overloadedMethod(String s){
        System.out.println("s");
    }
    static void overloadedMethod(Integer i){
        System.out.println("i");
    }*/
 /*
  public <T extends  Number> void  method(T arg){

  }
  public void method(Number arg){

  }*/
}
