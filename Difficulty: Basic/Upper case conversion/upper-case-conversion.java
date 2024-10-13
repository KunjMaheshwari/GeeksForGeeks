//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String str = br.readLine();
                    Solution ob = new Solution();
                    System.out.println(ob.transform(str));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String transform(String s)
    {
        // code here
        char[] ch = s.toCharArray();
        
        if(Character.isLowerCase(ch[0])){
            ch[0] = Character.toUpperCase(ch[0]);
        }
        
        for(int i=1;i<ch.length;i++){
            if(ch[i-1] == ' '){
                if(Character.isLowerCase(ch[i])){
                    ch[i] = Character.toUpperCase(ch[i]);
                }
            }
        }
        return new String(ch);
    }
}