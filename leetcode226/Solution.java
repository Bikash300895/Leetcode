package leetcode226;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    public TreeNode invertTree(TreeNode root) {
    	if(root == null){
			return root;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			TreeNode left = node.left;
			node.left = node.right;
			node.right = left;
			
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
		
		return root;
    }
}