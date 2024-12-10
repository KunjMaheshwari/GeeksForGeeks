//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int arr[][]) {
        Arrays.sort(arr,(a,b)->(a[1]-b[1]));
    	int s=arr[0][0];
    	int e=arr[0][1];
    	int cnt=0;
    	for(int i=1;i<arr.length;i++) {
    		if(Math.max(s, arr[i][0])<Math.min(e, arr[i][1])) {
    			cnt++;
    		}else {
    			s=arr[i][0];
    			e=arr[i][1];
    		}
    	}
        return cnt;
    }
}