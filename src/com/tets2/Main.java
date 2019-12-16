package com.tets2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String name = "abacabad";

        LinkedHashMap <Character, Integer> entryLinkedHashMap = new LinkedHashMap<>();
        for (int i=0; i < name.length(); i++){
            char ch = name.charAt(i);
            if (entryLinkedHashMap.containsKey(ch)) {
                entryLinkedHashMap.put(ch, (entryLinkedHashMap.get(ch) + 1));
            }
            else {
                entryLinkedHashMap.put(ch, 1);
            }
        }
        Iterator iterator = entryLinkedHashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry item = (Map.Entry) iterator.next();
            if ((Integer) item.getValue() == 1){
                System.out.println("Key = " + item.getKey() + " Value = " + item.getValue());
                return;
            }
        }
    }
}

