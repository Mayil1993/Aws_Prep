package com.aws.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestCommonString {

    private static String longestMatchingString(List<String> inputList){

        Map<String, Integer> wordCount = new HashMap<>();

        String[] strArr1 = inputList.get(0).split("\\s+");

        for(int i=1;i<inputList.size();i++){
            String[] split1 = inputList.get(i).split("\\s+");
            strArr1 = matchingSubstrin(strArr1,split1);
        }
        return String.join(" ",strArr1 );
    }

    private static String[] matchingSubstrin(String[] arr1, String[] arr2){

        int m = arr1.length;
        int n = arr2.length;

        int LCStuff[][] = new int[m + 1][n + 1];

        // To store length of the longest
        // common substring
      //  int result = 0;
        int x = 0, y = 0;
        // Following steps build
        // LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0 || j == 0)
                    LCStuff[i][j] = 0;
                else if (arr1[i - 1].equals(arr2[j - 1]))
                {
                    LCStuff[i][j]
                            = LCStuff[i - 1][j - 1] + 1;

                    if(LCStuff[i][j] > LCStuff[x][y] ){
             //           result = LCStuff[i][j];
                        x = i;
                        y = j;
                    }
                }
                else
                    LCStuff[i][j] = 0;
            }
        }
    //    return result;
        String[] result = new String[LCStuff[x][y]];
        int resultCount = 0;
        for(int i =x-LCStuff[x][y],j =y-LCStuff[x][y] ; i < x && j < y; i++,j++){
 //           System.out.println(arr1[i]);
            result[resultCount] = arr1[i];
            resultCount++;
        }

        return result;
    }

    public static void main(String[] args) {

        String s1 = "he i love india to";
        String s2 =  "els love indha to";
        String s3 =  "i hate love india to love india";

        System.out.println(longestMatchingString(Stream.of(s1, s2, s3).collect(Collectors.toList())));
    }
}
