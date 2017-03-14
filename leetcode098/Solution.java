package leetcode098;

import algorithmTree.TreeNode;

public class Solution {
	public boolean isValidBST(TreeNode root) {
        if(root == null)
        	return true;
        return halper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

	public boolean halper(TreeNode root, long min, long max ){
		if(root == null)
			return true;
		
		if(root.val<=min || root.val>=max)
			return false;
		
		else return (halper(root.left, min,root.val) && halper(root.right, root.val, max));
	}
}
