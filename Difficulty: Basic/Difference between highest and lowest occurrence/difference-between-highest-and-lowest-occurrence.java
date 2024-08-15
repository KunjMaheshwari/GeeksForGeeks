//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.findDiff(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long findDiff(long arr[], long n) {
        if (n == 0) {
            return 0; // or any other value that signifies an empty array
        }

        long maxFrequency = 0;
        long minFrequency = n;
        
        HashMap<Long, Long> map = new HashMap<>();
        
        // Counting frequency of each element
        for (long i = 0; i < n; i++) {
            map.put(arr[(int)i], map.getOrDefault(arr[(int)i], 0L) + 1);
        }
        
        // Finding the max and min frequency
        for (long frequency : map.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
            minFrequency = Math.min(minFrequency, frequency);
        }
        
        return maxFrequency - minFrequency; // Returning the difference between max and min frequencies
    }
}