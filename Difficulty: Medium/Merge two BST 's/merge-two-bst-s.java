//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution T = new Solution();
            List<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();

            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {
    /*
    * this function is for inorder traversal it adds data to a Queue 
    *
    */
    protected void inorder(Node root, Queue<Integer> q ){
        if(root == null){
            return;
        }
        inorder(root.left, q);
        q.offer(root.data);
        inorder(root.right, q);
    }
    /*
    * problem function provided to us 
    *
    */
    public List<Integer> merge(Node root1, Node root2) {
        // declaration section 
        //q1 = queue to store the data for first BST
        //q2 = queue to store the data for second BST
        //res = resultant list
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        
        //filling the Q's with their respective values
        inorder(root1, q1);
        inorder(root2, q2);
        
        //here is the usage of sorted merging
        while(!q1.isEmpty() && !q2.isEmpty()){
            if(q1.peek() < q2.peek())
                res.add(q1.poll());
            else
                res.add(q2.poll());
        }
        
        //adding the remaining elements
        res.addAll(q1);
        res.addAll(q2);
        
        return res;
    }
}
