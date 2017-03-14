package leetcode396;

public class Solution {
	
	public int maxRotateFunction(int[] A) {
        int n = A.length;
        int max = Integer.MIN_VALUE;
        int sum=0;
        if(n==0 ||  n==1)
        	return 0;
        
        for(int i=0; i<n; i++){ //Timer loop, how many time we will try to sum up and find the max
        	
        	sum = 0;
        	int k=0;
        	
        	for(int j=i; j<i+n; j++){   // Index selector
        	
        		int m;
        		
        		if(j<n){
        		    m=j;
        		} else {
        		    m = j-n;
        		}
        		
        		sum += A[m]*k;
        		k++;
        			
        	}
        	
        	
        	max = Math.max(max, sum);
        }
        
        return max;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int [] A = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(s.maxRotateFunction(A));
	}

}
