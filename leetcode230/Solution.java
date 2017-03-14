package leetcode230;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
    	int count = 0;
    	
        TreeNode current = root;
        
        while(current != null){
        	if(current.left == null){
        		count++;
        		if(count==k)
        			return current.val;
        		current = current.right;
        	}else{
        		TreeNode pre = current.left;
        		while(pre.right!=null && pre.right!=current)
        			pre = pre.right;
        		
        		if(pre.right == null){
        			pre.right = current;
        			current = current.left;
        		}else{
        			pre.right = null;
        			count++;
        			if(count == k)
        				return current.val;
        			
        			current = current.right;
        		}
        	}
        }
        return -1;
    }
}