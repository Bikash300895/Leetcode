package leetcode391;

public class Solution {
	
	public boolean isRectangleCover(int[][] A) {
        int m = A.length;
        int minlbrow = Integer.MAX_VALUE, minlbcol = Integer.MAX_VALUE, maxrurow = 0, maxrucol = 0;
        for (int i = 0; i < m; i++) {
            minlbrow = Math.min(minlbrow, A[i][1]);
            minlbcol = Math.min(minlbcol, A[i][0]);
            maxrurow = Math.max(maxrurow, A[i][3]);
            maxrucol = Math.max(maxrucol, A[i][2]);
        }
        int[] largest = {minlbrow, minlbcol, maxrurow, maxrucol};
        int alarge = area(largest);
        int asum = 0;
        for (int i = 0; i < m; i++) {
            asum += area(A[i]);
        }
        return asum == alarge;
    }
    public int area(int[] a) {
        if (a.length != 4) return 0;
        return (a[2]-a[0]) * (a[3]-a[1]);
    }

	public static void main(String[] args) {
		

	}

}
