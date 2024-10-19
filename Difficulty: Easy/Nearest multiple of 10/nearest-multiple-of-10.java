//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        // Complete the function
        int n=str.length();
        if(str.charAt(n-1)<='5') return str.substring(0,n-1)+'0';
        str=str.substring(0,n-1)+'9';
        int i=n-1;
        while(i>=0 && str.charAt(i)=='9'){
            i--;
            if(i==-1) return '1'+"0".repeat(n);
        }
        return str.substring(0,i)+(char)(str.charAt(i)+1)+"0".repeat(n-i-1);
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends