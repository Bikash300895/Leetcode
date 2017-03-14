package leetcode387;

public class Solution {
	public int firstUniqChar(String S){
		int n =S.length();
		char[] s = S.toCharArray();
		
		int[] count = new int[256];
		for(int i=0; i<n; i++){
			count[s[i]]++;
		}
		
		for(int i=0; i<n; i++){
			if(count[s[i]]==1){
				return i;
			}
		}
		
		return -1;
	}
}
