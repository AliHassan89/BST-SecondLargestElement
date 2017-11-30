/*

Write a method to find the 2nd largest element in a binary search tree

 */
package bstsecondlargestelement;

/**
 *
 * @author Ali
 */
public class BSTSecondLargestElement 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Node root = new Node(50);
        root.right = new Node(55);
        root.left = new Node(30);
        root.left.right = new Node(35);
        root.left.left = new Node(25);
        root.left.left.left = new Node(20);
        
        System.out.println(secondLargestElement(root));
    }
    
    private static int secondLargestElement(Node root)
    {
        if (root == null)
            return -1;
        
        return secondLargestElementUtil(root, Integer.MIN_VALUE);
    }
    
    private static int secondLargestElementUtil(Node root, int secondLargest)
    {
        if (root == null)
        {
             return secondLargest;
        }
        
        if (root.right != null)
        {
             secondLargest = root.data;
             secondLargestElementUtil(root.right, secondLargest);
        }
        else if (root.left != null && secondLargest < root.left.data)
        {
            //largest in left subtree
             secondLargest = largestElement(root.left);
        }
        
        return secondLargest;
    }
    
    private static int largestElement(Node root)
    {
        if (root == null)
            return 0;
        
        if (root.right != null)
            return largestElement(root.right);
        
        return root.data;
    }
    
}
