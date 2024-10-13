//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().stringSort (s));
        }
        
    }
}
// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Sol
{
     public static String stringSort (String s)
    {
        // your code here
        
        ArrayList<Character>low=new ArrayList<>();
        ArrayList<Character>upper=new ArrayList<>();
        for(char c:s.toCharArray()){
            if(Character.isLowerCase(c))low.add(c);
            if(Character.isUpperCase(c))upper.add(c);
        }
        Collections.sort(low);
        Collections.sort(upper);
        StringBuilder sb=new StringBuilder();
        int i=0;
        int j=0;
        while(i<low.size() && j<upper.size()){
            
            sb.append(upper.get(j++));
            sb.append(low.get(i++));
        }
        while(i<low.size())sb.append(low.get(i++));
        while(j<upper.size())sb.append(upper.get(j++));
        return sb.toString();
    }
}