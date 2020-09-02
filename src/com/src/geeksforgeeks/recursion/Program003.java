package com.src.geeksforgeeks.recursion;

class TreeNode {
	int val;
	TreeNode left;
    TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
	    this.left = left;
	    this.right = right;
	}
}
public class Program003 {
	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(1,new TreeNode(2,new TreeNode(4,null,null),null),new TreeNode(3,null,null));
		int height = getDepth(rootNode,4,0);
		int height2 = getDepth(rootNode,3,0);
		System.out.println(height);
	}
	public static int getDepth(TreeNode currNode,int target,int height) {
        if(currNode!=null) {
        	if(currNode.val == target) {
                return height;
            }
        	int val = getDepth(currNode.left,target,height+1);
        	if(val != -1) {
        		return val;
        	}
        	return getDepth(currNode.right,target,height+1);
        }else {
        	return -1;
        }
    }
}
