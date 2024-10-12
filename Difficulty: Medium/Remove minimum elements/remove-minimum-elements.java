//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Corrected to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution ob = new Solution();
            System.out.println(
                ob.minRemoval(arr)); // Passes the int[] array to the method
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the minimum number of elements to be removed.
    public int minRemoval(int[] arr) {
        Arrays.sort(arr);
        int maxL = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int j = ceilIndex(i,arr,2 * arr[i]);
            maxL = Math.max(maxL,j - i + 1);
        }
        return arr.length - maxL;
    }
    
    public static int ceilIndex(int s,int[] arr,int target){
        int e = arr.length - 1;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(arr[mid] > target){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return e;
    }
}