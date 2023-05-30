package org.example;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String a = "1";
        String b = "11";


        System.out.println(addBinary(a, b));

    }

    public static String addBinary(String a, String b) {
        while(a.length() != b.length()){
            if(a.length() > b.length()){
                b = "0" + b;
            } else{
                a = "0" + a;
            }
        }

        String finalNum = "";


        for(int workingChar = a.length() -1; 0 < workingChar; workingChar--){

            if(a.charAt(workingChar) != b.charAt(workingChar)){
                finalNum = "1" + finalNum;
            } else if (a.charAt(workingChar) == '1') {

            }
        }

        return finalNum;
    }

    public static int removeElement(int[] nums, int val) {
        int totalNonVal = nums.length;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                nums[i] = 101;
                totalNonVal -= 1;
            }
        }

        Arrays.sort(nums);


        return totalNonVal;
    }

    public static int[] plusOne(int[] digits) {

        int highestNine = -1;

        for(int i = digits.length - 1; digits[i] == 9; i--){
            digits[i] = 0;
            highestNine = i;
        }
        if(highestNine == 0){
            int[] intArray = new int[digits.length + 1];
            Arrays.fill(intArray, 0);
            intArray[0] = 1;
        }
        else if(highestNine != -1){
            digits[highestNine-1] += 1;
        } else {
            digits[digits.length-1] += 1;
        }

        return digits;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        int[] array = new int[k];

        for(int i = 0; i < nums.length; i++){
            if(tree.containsKey(nums[i])){
                tree.put(nums[i], tree.get(nums[i])+1);
            } else {
                tree.put(nums[i], 1);
            }
        }

        for(int i = 0; i < k; i++){
            Integer workingValue = 0;
            Integer key = 0;
            for (Map.Entry<Integer, Integer> entry : tree.entrySet()) {
                if(entry.getValue() > workingValue){
                    workingValue = entry.getValue();
                    key = entry.getKey();
                }
            }
            tree.remove(key);
            array[i] = key;
        }

        return array;
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