//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to determine if array arr can be split into three equal sum sets.
    public List<Integer> findSplit(int[] arr) {
        // code here
        int sum =0;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
        }
        
        if(sum%3 !=0){
            return Arrays.asList(-1,-1);
        }
        
        List<Integer> st = new ArrayList<>();
        int currentsum =0;
        int count =0;
        for(int left =0,right=0;right<arr.length;right++){
            currentsum +=arr[right];
            while(currentsum == sum/3 && count<3){
                st.add(left);
                left = right +1 ;
                currentsum =0;
                count++;
            }
        }
        if(count!=3){
            return Arrays.asList(-1,-1);
        }
        return st;
        
    }
}