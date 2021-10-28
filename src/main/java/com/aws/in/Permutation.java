package com.aws.in;

import java.util.Locale;

public class Permutation {

    private static boolean isPerumtation(String s1, String s2){

        if(s1.length() != s2.length()){
            return false;
        }
        int[] arr = new int[128];

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        for (int i=0;i<chars1.length;i++){
            arr[chars1[i]] += 1;
        }

        for (int i=0;i<chars2.length;i++){
            if(arr[chars2[i]]-1 < 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "god";
        String s2 = "dog";
        System.out.println(isPerumtation(s1,s2));
    }
}
