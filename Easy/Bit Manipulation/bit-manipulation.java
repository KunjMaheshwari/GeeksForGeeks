//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int i = sc.nextInt();

            Solution obj = new Solution();
            obj.bitManipulation(n, i);
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int getithBit(int num, int i) {
        int bitMask = 1 << (i - 1);
        return (num & bitMask) != 0 ? 1 : 0;
    }
    
    public static int setithBit(int num, int i){
        int bitMask = 1<<(i-1);
        
        return num | bitMask;
    }
    
    public static int clearithBit(int num, int i){
        int bitMask = 1<<(i-1);
        
        return num & ~(bitMask);
    }

    static void bitManipulation(int num, int i) {
        // code here
        
        System.out.print(getithBit(num, i)+" ");
        
        System.out.print(setithBit(num, i)+" ");
        
        System.out.print(clearithBit(num, i));
        
    }
}
