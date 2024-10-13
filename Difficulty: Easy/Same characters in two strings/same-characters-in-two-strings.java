//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while(t-- > 0){
            String A = sc.nextLine().trim();
            String B = sc.nextLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.sameChar(A, B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int sameChar(String A, String B) 
    {
        // Convert both strings to lowercase to ignore case sensitivity
        A = A.toLowerCase();
        B = B.toLowerCase();
        int count=0;
        
        // Use a HashSet to store unique characters from string B
        for(int i=0;i<A.length();i++){
            if(A.charAt(i) == B.charAt(i)){
                count++;
            }
        }
        return count;
    }
}