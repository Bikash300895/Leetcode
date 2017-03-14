package leetcode235;

/**
 * 
 * @author Shuvendu Roy Bikash
 * link :: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * The problem is to find the lowest ancestor
 * 
 * Complixity : O(n log n)
 * Verdict: Accepted
 *
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root.val > Math.max(p.val,q.val)){
			return lowestCommonAncestor(root.left,p,q); 
		}else if(root.val < Math.min(p.val, q.val)){
			return lowestCommonAncestor(root.right,p,q);
		} else{
			return root;
		}	
    }
}