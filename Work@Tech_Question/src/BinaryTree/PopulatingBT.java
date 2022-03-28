package BinaryTree;

public class PopulatingBT {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Node connect(Node root) {
		
		Node temp = root;
		
		while(root!=null && root.left!=null) {
			
			Node n = temp;
			
			while(true) {
				
				n.left.next = n.right;
				
				if(n.next==null) break;
				
				n.right.next = n.next.left;
				
				n = n.next;
					
					
			}
			
			temp = temp.left;
			
		}
		
		return root;
	}

}
