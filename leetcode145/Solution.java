package leetcode145;

import java.util.ArrayList;
import java.util.Stack;

import algorithmTree.TreeNode;

public class Solution {
	public ArrayList<Integer> PostOrder(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> S = new Stack<>();
		
		TreeNode p = root;
		TreeNode q = null;
		do{
			while(p!=null){
				S.push(p);
				p=p.left;
			}
				
			
			q=null;
			while(!S.empty()){
				
				p = S.peek();
				S.pop();
				
				if(p.right == q){
					result.add(p.val);
					q=p;
				} else {
					S.push(p);
					p = p.right;
					break;
				}
			}
		} while(!S.empty());
		
		return result;
	}
}