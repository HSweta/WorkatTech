package BinaryTree;

import java.util.Stack;

public class FlattenBT {
	class Node {
		public Node left;
	    public Node right;
	    int data;

	    Node(int data) {
	        this.data = data;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void flatten(Node root) {
    	Stack<Node> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()){
		    Node t = s.pop();
			
			if(t.right!=null)
				s.push(t.right);
			
			if(t.left!=null)
				s.push(t.left);
			
			if(!s.isEmpty()){
			t.right = s.peek();
			t.left = null;
			}
			
		}
	}
	
	public void flattenMorrisTraversal(Node root) {
		
		Node curr = root;
		
		while(curr!=null) {
			
			if(curr.left!=null) {
				
				Node prev = curr.left;
				
				while(prev.right!=null)
					prev = prev.right;
				
				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
				
			}
			
			curr = curr.right;
		}
		
	}

}
