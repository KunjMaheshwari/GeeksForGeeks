//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to check whether two strings are anagrams of each other
    public static boolean areAnagrams(String s1, String s2) {

        // Your code here
        int n = s1.length();
        int m = s2.length();
         if(n != m)
          return false;
          
        HashMap<Character,Integer> count = new HashMap<>();
        for(char ch :s1.toCharArray())
        {
            count.put(ch,count.getOrDefault(ch,0)+1);
        }
        for(char ch : s2.toCharArray())
        {
            if(!count.containsKey(ch))
               return false;
        
        count .put(ch,count.get(ch)-1);
        if(count.get(ch)<0)
        {
            return false;
        }
        }
        for (int i : count.values()) {
            if (i != 0) {
                return false;
            }
        }
        
        return true; 
    }
}