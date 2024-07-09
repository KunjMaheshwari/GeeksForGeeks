//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    static int threeSumClosest(int[] array, int target) {
        // code here
        int closenumber = Integer.MAX_VALUE;
        int mindiff = Integer.MAX_VALUE;
        Arrays.sort(array);
        for(int a = 0; a < array.length; a++){
            // if(a>0 && && array[a] == array[a+1]) continue;
            int i = a+1;
            int j = array.length-1;
            int sum = 0 ; 
            while(i<j){
                sum = array[a] + array[i] + array[j];
                if(sum==target){
                    return target;
                }
                else if(sum < target){
                    int diff = target - sum;
                    if(mindiff > diff){
                        mindiff = diff;
                        closenumber = sum;
                    }
                    else if(mindiff == diff){
                        closenumber = Math.max(closenumber,sum);
                    }
                    i++;
                }
                else{
                    int diff = sum - target;
                    if(mindiff > diff){
                        mindiff = diff;
                        closenumber = sum;
                    }
                    else if(mindiff == diff){
                        closenumber = Math.max(closenumber,sum);
                    }
                    j--;
                }
            }
            
            
        }
        return closenumber;
        
    }
}
