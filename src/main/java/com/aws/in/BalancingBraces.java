package com.aws.in;

import java.util.*;

public class BalancingBraces {

    private static Map<Character, Character> map;

    static {
        map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
    }
    private static boolean isBalanced(String s){
        char[] chars = s.toCharArray();
 //       Stack<Character> braces = new Stack<>();
        Deque<Character> braces = new LinkedList<>();

        for(int i=0; i<chars.length;i++){
            if(!braces.isEmpty() && map.get(chars[i])!= null && map.get(chars[i]).equals(braces.peek())){
                braces.pop();
            }else{
                braces.push(chars[i]);
            }
        }
        return braces.isEmpty();
    }
    public static void main(String[] args) {
        String s1 = "([]){}";
        String s2 = "{(){}[]";
        System.out.println(isBalanced(s1));
        System.out.println(isBalanced(s2));
    }
}
