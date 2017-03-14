package leetcode394;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static Set<Character> lookup = new HashSet<Character>();
    static{
        lookup.add('0');
        lookup.add('1');
        lookup.add('2');
        lookup.add('3');
        lookup.add('4');
        lookup.add('5');
        lookup.add('6');
        lookup.add('7');
        lookup.add('8');
        lookup.add('9');
    }
    
    public String decodeString(String s) {
        String normalChars = "";
        String digits = "";
        int index = 0;
        
        // Pick up all the non-numeric characters before a repeated section
        while(index < s.length() && !lookup.contains(s.charAt(index))){
            normalChars += s.charAt(index);
            index++;
        }
        
        // Terminating case: If the string is only non-numeric characters
        if(index == s.length()) return s;
        
        // Pick up all the digits
        while(index < s.length() && s.charAt(index) != '['){
            digits += s.charAt(index);
            index++;
        }
        
        // Find the index of the matching parentheses
        int endIndex = closingParens(s, index);
        String expansion = expandRepeatingPart(s.substring(index + 1, endIndex), Integer.parseInt(digits));
        if(endIndex == s.length()){
            // There is nothing on the right side
            return decodeString(normalChars + expansion);
        }
        else{
            return decodeString(normalChars + expansion) + decodeString(s.substring(endIndex + 1));
        }
    }
    
    static String expandRepeatingPart(String s, int n){
        String result = "";
        for(int i = 0; i < n; i++){
            result += s;
        }
        return result;
    }
    
    static int closingParens(String s, int start){
        int counter = 1;
        int end = start + 1;
        while(end < s.length() && counter != 0){
            if(s.charAt(end) == '['){
                counter++;
            }
            if(s.charAt(end) == ']'){
                counter--;
            }
            end++;
        }
        if(counter == 0) return end - 1;
        return -1;
    }
}