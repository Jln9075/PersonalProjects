package org.example;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] words = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(words));

    }
    public static int smallestWord(String[] strings){
        String first = strings[0];

        for(int i = 1; i < strings.length; i++){
            if(strings[i].length() < first.length()){
                first = strings[i];
            }
        }
        return first.length();
    }
    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int largestPossible = smallestWord(strs);
        boolean isPrefixAccurate = false;

        while(isPrefixAccurate == false){
            prefix = strs[0].substring(0, largestPossible);
            for(int i = 0; i < strs.length; i++){
                if(!prefix.equals(strs[i].substring(0, largestPossible))){
                    i = 0;
                    largestPossible -= 1;
                    break;
                } else if(i == strs.length - 1){
                    isPrefixAccurate = true;
                }
            }
        }

        return prefix;
    }
    public static String longestPalindrome(String s) {
        String longestSubstring = "";

        for(int i = 0; i < s.length(); i++){
            char indexedChar = s.charAt(i);
            int index = s.indexOf(indexedChar, i+1);


            while(index != -1 ){
                String substring = s.substring(i, index+1);
                if(check(substring) && substring.length() > longestSubstring.length()){
                    longestSubstring = substring;
                } else if(longestSubstring.length() == s.length()){
                    return longestSubstring;
                }
                index = s.indexOf(indexedChar, index+1);
            }
        }
        return longestSubstring;
    }

    public static boolean check(String s){
        boolean isBoolean = true;
        int right = s.length()-1;

        for (int left = 0; left - right <=0; left++){
            if(s.charAt(left) != s.charAt(right)){
                isBoolean = false;
            }
            right--;
        }

        return isBoolean;
    }
    public static int lengthOfLongestSubstring(String s) {
        Set substringSet = new HashSet<>();
        int longestLength = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){

            if(!substringSet.contains(s.charAt(right))){
                substringSet.add(s.charAt(right));
                longestLength = Math.max(right - left + 1, longestLength);
            } else {
                while(s.charAt(left) != s.charAt(right)){
                    substringSet.remove(s.charAt(left));
                    left++;
                }
                substringSet.remove(s.charAt(left));left++;
                substringSet.add(s.charAt(right));
            }
        }
        return longestLength;
    }



}