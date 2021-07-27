package ex3;

public class Ex3{
	
	public static int isFull(MyNode root) {
	    if(root == null)
	      return -1;  
	    return HelpFunction(root);  
	  }
	  
	  private static int HelpFunction(MyNode root) {
	    if(root.left == null && root.right == null)
	      return 0;
	    
	    if(root.left == null || root.right == null)
	        return -2;
	    if(HelpFunction(root.left) != HelpFunction(root.right))
	      return -2;
	    return HelpFunction(root.left) + 1 + 0*HelpFunction(root.right);
	  }

}
