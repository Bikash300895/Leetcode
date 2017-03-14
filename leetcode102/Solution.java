package leetcode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import algorithmTree.TreeNode;

public class Solution {
	public ArrayList <ArrayList<Integer> > Traverse(TreeNode root){
		ArrayList <ArrayList<Integer> > result = new ArrayList < ArrayList<Integer> >();
		Queue<TreeNode> current = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		
		ArrayList<Integer> level = new ArrayList<>();
		
		current.add(root);
		
		while(!current.isEmpty()){
			while(!current.isEmpty()){
				TreeNode node = current.poll();
				level.add(node.val);
				
				if(node.left!=null) next.add(node.left);
				if(node.right!=null) next.add(node.right);
			}
			result.add(level);
			level.clear();
			
			Queue<TreeNode> temp = current;
			current= next;
			next = temp;
			
		}
		return result;
	}
}
