package leetcode099;

import algorithmTree.*;

public class Solution {
	TreeNode node1 = null;
	TreeNode node2 = null;
	TreeNode Pre = null;
	
	public void helper(TreeNode root){
		if(root == null)
			return;
		
		helper(root.left);
		
		if(Pre!=null && Pre.val>root.val){
			if(node1 == null){
				node1 = Pre;
			}
			node2 = root;
		}
		
		Pre = root;
		helper(root.right);
	}
	
	public void recoverTree(TreeNode root){
		if(root ==null){
			return;
		}
		
		helper(root);
		
		if(node1!=null && node2!=null){
			int temp  = node1.val;
			node1.val=node2.val;
			node2.val= temp;
		}
	}
}
