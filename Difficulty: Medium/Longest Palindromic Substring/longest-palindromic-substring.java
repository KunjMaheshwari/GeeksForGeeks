//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String longestPalindrome(String S){
        // code here
        String m="";
        for(int i=0;i<S.length();i++){
           String odd=value(S,i,i);
            String even=value(S,i,i+1);
            if(odd.length()>even.length()&&odd.length()>m.length())
            m=odd;
            else if(odd.length()<even.length()&&even.length()>m.length())
            m=even;
           
        }
        return m;
    }
    String value(String s,int i,int j){
       String ans="";
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j))
        {
            i--;j++;
            
        }
       ans=s.substring(i+1,j);
       return ans;
    }
}
