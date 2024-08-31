//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] < arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();

        if (n < 3) {
            return result; // No triplet possible
        }

        int[] smaller = new int[n];
        int[] greater = new int[n];

        // Initialize smaller array with -1
        smaller[0] = -1; // No smaller element on the left for the first element
        int minIndex = 0; // Initialize the minimum index to the first element

        // Populate smaller array
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[minIndex]) {
                minIndex = i;
                smaller[i] = -1; // No smaller element to the left
            } else {
                smaller[i] = minIndex; // Store index of the smallest element on the left
            }
        }

        // Initialize greater array with -1
        greater[n - 1] = -1; // No greater element on the right for the last element
        int maxIndex = n - 1; // Initialize the maximum index to the last element

        // Populate greater array
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[maxIndex]) {
                maxIndex = i;
                greater[i] = -1; // No greater element to the right
            } else {
                greater[i] = maxIndex; // Store index of the greatest element on the right
            }
        }

        // Find the triplet such that arr[smaller[i]] < arr[i] < arr[greater[i]]
        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                result.add(arr[smaller[i]]);
                result.add(arr[i]);
                result.add(arr[greater[i]]);
                return result; // Return the first triplet found
            }
        }

        return result; // No triplet found
    }
}
