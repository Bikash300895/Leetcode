package leetcode386;

import java.util.ArrayList;

public class Solution {
    private ArrayList<Integer> result;
    private int n;
    public ArrayList<Integer> lexicalOrder(int n) {
        this.result = new ArrayList<Integer>();
        this.n = n;
        solve(1);
        return result;
    }
    private void solve(int m) {
        result.add(m);
        if (m * 10 <= n) solve(m * 10);
        if (m < n && m % 10 < 9) solve(m + 1);
    }
}