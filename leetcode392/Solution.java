package leetcode392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean flag = true;
        
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        
        int n = s.length();
        int m = t.length();
        
        int i=0,j=0;
        for(; i<n; i++){
        	if (j==m){
        		flag=false;
        		break;
        	}
        	for(; j<m; j++){
        		if(S[i] == T[j]){
        			j++;
        			break;
        		}
        	}

        }
        
        return flag;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.isSubsequence("abc", "ahbgdc"));
    }
}