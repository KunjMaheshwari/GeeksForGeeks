//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends




class Solution {
    public boolean canSplit(int arr[]) {
       if(arr.length==1){
            return false;
        }
        int start =1;
        int end = arr.length-2;
        int sleft =arr[0];
        int sright =arr[arr.length-1];
        while(start<=end){
            if(sleft<=sright){
                sleft += arr[start];
                start++;
            }
            else{
                sright += arr[end];
                end--;
            }
        }
        if(sleft==sright){
            return true;
        }
        return false;   // code here
    }
}