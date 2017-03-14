package leetcode389;

public class Solution {
    public char findTheDifference(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int l1 = s.length();
        int l2 = t.length();
        int [] count = new int[l1];
        
        int j;
        for(int i=0; i<l2; i++){
        	for(j=0; j<l1; j++){
        		if(T[i]==S[j] && count[j]==0){
        			count[j]=1;
        			break;
        		}
        	}
        	if(j==l1)
        		return T[i];
        }
        return 'X';
    }
}