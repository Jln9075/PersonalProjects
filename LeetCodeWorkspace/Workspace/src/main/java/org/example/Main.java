package org.example;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("mozblnzrszxtdjmwvgeovtxoftpcsbnjryogrnibiiqfexljlfikfcxvrzrpfvugtdjrlkgvkmrqgeltifdehsewpdhpjpnuobmuozopmglnocqcozvratjpzrklexqdeuvvzfjkuknkkoynxptrgtzadmpfdkphfjhdulhzncoofmmrwqjxeyhodfavcgpjmohohuztezdxegqzbaaobzrqptuqsvwnfdneyccbkgkjafztytwuppvleukdqqzyeiltsvoqbxupbasiityganofxijucwzqgtdyxljociwwjdrnfnfbwyymmvbuvbrdnvcubzkohknbsneutrcukfiqqhfviqdsbtrldipenqifdcrenpuyaqvkparycksurhbtjppwhezbcgocamurdawimkzzkmiwadrumacogcbzehwppjtbhruskcyrapkvqayupnercdfiqnepidlrtbsdqivfhqqifkucrtuensbnkhokzbucvndrbvubvmmyywbfnfnrdjwwicojlxydtgqzwcujixfonagytiisabpuxbqovstlieyzqqdkuelvppuwtytzfajkgkbccyendfnwvsqutpqrzboaabzqgexdzetzuhohomjpgcvafdohyexjqwrmmfoocnzhludhjfhpkdfpmdaztgrtpxnyokknkukjfzvvuedqxelkrzpjtarvzocqconlgmpozoumbounpjphdpweshedfitlegqrmkvgklrjdtguvfprzrvxcfkifljlxefqiibinrgoyrjnbscptfoxtvoegvwmjdtxzsrznlbzom"));

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