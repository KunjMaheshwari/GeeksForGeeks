//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public int[] twoOddNum(int Arr[], int N) {
        // Step 1: XOR all elements to get xor2
        int xor2 = 0;
        for (int num : Arr) {
            xor2 ^= num;
        }

        // Step 2: Find rightmost set bit in xor2
        int setBit = xor2 & ~(xor2 - 1);

        // Step 3: Partition the array into two sets and XOR the numbers in each set
        int x = 0, y = 0;
        for (int num : Arr) {
            if ((num & setBit) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        // Step 4: Ensure x and y are in decreasing order
        if (x > y) {
            return new int[]{x, y};
        } else {
            return new int[]{y, x};
        }
    }
}
