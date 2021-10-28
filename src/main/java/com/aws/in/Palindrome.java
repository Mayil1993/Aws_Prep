package com.aws.in;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Palindrome {

    private static boolean isPalindrome(String s1){

        char[] chars = s1.toCharArray();

        Set<Character> set = new LinkedHashSet<>();

        for(int i=0;i<chars.length;i++){
            if(chars[i] == ' '){
                continue;
            }
            if(set.contains(chars[i])){
                set.remove(chars[i]);
            }else{
                set.add(chars[i]);
            }
        }
        return set.size() == 0 || set.size() == 1;
    }

    public static void main(String[] args) {
        String s1 = "tact coa";
        System.out.println(isPalindrome(s1));
    }
}
