package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class InputExample {

    public static void main(String[] args) {

        String inputString = "GGGGGrrrrrrrrrrrrrrt";

        String[] str = inputString.split("");
        Set<String> linkedSet = new LinkedHashSet<String>();
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        String output = "";

        for (String s : str) {
            if (!linkedSet.contains(s)) {
                linkedSet.add(s);
                hashMap.put(s, 0);
            }
            if (linkedSet.contains(s)) {
                hashMap.put(s, hashMap.get(s) + 1);
            }
        }
        for (String st : linkedSet) {
            String val =  hashMap.get(st).toString();
            output = output + val + st;
       }

       System.out.println(output);

    }
}