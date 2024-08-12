//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;

        // Merge the two arrays
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        // If there are remaining elements in arr1
        while (i < n) {
            merged[k++] = arr1[i++];
        }

        // If there are remaining elements in arr2
        while (j < m) {
            merged[k++] = arr2[j++];
        }

        // Since n and m are the same, the length of the merged array is even
        int middle1 = merged[(n + m) / 2 - 1];
        int middle2 = merged[(n + m) / 2];

        return middle1 + middle2;
    }
}


//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends