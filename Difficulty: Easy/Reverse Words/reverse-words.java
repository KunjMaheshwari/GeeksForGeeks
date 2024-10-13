//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        String s[] = str.split("\\.");
        
        String out = "";
        
        for(int i=s.length-1;i>=0;i--){
            out += s[i];
            if(i > 0){
                out += '.';
            }
        }
        return out;
    }
}