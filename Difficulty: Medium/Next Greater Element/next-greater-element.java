//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution {
    // Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> s = new Stack<Long>();
        long nextGreater[] = new long[n];
        
        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack smaller than or equal to the current element
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }
            
            // If the stack is empty, there is no greater element to the right
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                // The top element of the stack is the next greater element
                nextGreater[i] = s.peek();
            }
            
            // Push the current element onto the stack
            s.push(arr[i]);
        }
        
        return nextGreater;
    }
}