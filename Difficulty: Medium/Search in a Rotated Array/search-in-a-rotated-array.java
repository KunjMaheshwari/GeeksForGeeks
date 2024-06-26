//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[] = in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(n, A, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int n, int[] arr, int key) {
        // Complete this function
        int si = 0;
        int ei = n-1;
        
        return binarySearch(arr, key, si, ei);
    }
    public static int binarySearch(int arr[], int target, int si, int ei){
        int mid = si+(ei-si)/2;
        int left = -1;
        int right = -1;
        
        if(si<=ei){
            if(arr[mid] == target){
                return mid;
            }else{
                left = binarySearch(arr, target, si, mid-1);
                right = binarySearch(arr, target, mid+1, ei);
            }
        }
        return Math.max(left, right);
    }
}