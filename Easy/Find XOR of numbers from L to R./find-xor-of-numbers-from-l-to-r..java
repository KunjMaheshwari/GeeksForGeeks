//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int l;
            l = sc.nextInt();

            int r;
            r = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.findXOR(l, r);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int xorOfElement(int n){
        if(n%4 == 1){
            return 1;
        }else if(n%4 == 2){
            return n+1;
        }else if(n%4 == 3){
            return 0;
        }else{
            return n;
        }
    }
    public static int findXOR(int l, int r) {
        int xorOfl = xorOfElement(l-1); // because x^x = 0 and we need l in our answer therefore we will do it till l-1
        int xorOfr = xorOfElement(r);
        
        return xorOfl^xorOfr;
    }
}