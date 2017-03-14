package leetcode094;

import java.util.ArrayList;
import java.util.Stack;

import algorithmTree.TreeNode;

public class Solution {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        
        while(!s.isEmpty() || p!=null){
        	if(p!=null){
        		s.push(p);
        		p=p.left;
        	} else {
        		p=s.peek();
        		s.pop();
        		list.add(p.val);
        		p = p.right;
        	}
        }
        
        return list;
    }
}
