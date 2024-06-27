//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int nums[], int size) {
        // Find the candidate for majority element
        int candidate = majorityElementRec(nums, 0, size - 1);
        
        // Verify if the candidate is actually the majority element
        int count = countInRange(nums, candidate, 0, size - 1);
        if (count > size / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
    
    public static int countInRange(int nums[], int num, int lo, int hi){
        int count = 0;
        
        for(int i = lo;i<=hi;i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }
    
    public static int majorityElementRec(int nums[], int lo, int hi){
        // base case 
        if(lo ==  hi){
            return nums[lo];
        }
        
        int mid = lo+(hi-lo)/2;
        int left = majorityElementRec(nums,lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);
        
        if(left ==  right){
            return left;
        }
        
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        
        return leftCount > rightCount ? left : right;
    }
}