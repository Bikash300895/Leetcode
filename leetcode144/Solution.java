package leetcode144;

import java.util.ArrayList;
import java.util.Stack;

import algorithmTree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root==null)
        	return list;
        s.add(root);
        
        while(!s.isEmpty()){
        	TreeNode temp = s.peek();
        	s.pop();
        	list.add(temp.val);
        	
        	if(temp.right!=null)
        		s.push(temp.right);
        	if(temp.left!=null)
        		s.push(temp.left);
        	
        }
        
        return list;
    }
}