//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        // Your code here
        int normalSum=maxSubarraySum(arr);
        if(normalSum<0)
        {
            return normalSum;
        }
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            arr[i]=-arr[i];
        }
        int circularSum=sum+maxSubarraySum(arr);
        int res=Math.max(circularSum,normalSum);
        return res;
    }
    public static int maxSubarraySum(int arr[])
    {
        int sum=0;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum<0)
            {
                sum=0;
            }
            if(sum>res)
            {
                res=sum;
            }
        }
        return res;
    }
}
