package BinaryTree;

public class maxSumBT {
   
	class Node {
		public Node left;
		public Node right;
		public int data;

		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		

	}
	
   public int maxPathSum(Node root) {
		int[] maxValue = new int[1];
		maxPath(root,maxValue);
		return maxValue[0];
		
	}
	
	public int maxPath(Node node,int[] maxValue) {
		
		if(node==null) return 0;
		
		int left = Math.max(0, maxPath(node.left,maxValue));
		int right = Math.max(0, maxPath(node.right,maxValue));
		
		maxValue[0] = Math.max(left+right+node.data, maxValue[0]);
		
	    return Math.max(left, right)+node.data;
	   
	}

}
