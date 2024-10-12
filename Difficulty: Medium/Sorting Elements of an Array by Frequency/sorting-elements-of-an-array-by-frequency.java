import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        
        while (T-- > 0) {
            int N = sc.nextInt(); // Size of the array
            int[] arr = new int[N];
            
            // Input array
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            // Step 1: Create a HashMap to store the frequency of each element
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            // Step 2: Create a list to sort the elements based on frequency
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(arr[i]);
            }

            // Step 3: Sort the list using a custom comparator
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    int freqA = map.get(a);
                    int freqB = map.get(b);
                    // Sort by frequency in descending order
                    if (freqA != freqB) {
                        return freqB - freqA;
                    }
                    // If frequencies are the same, sort by value in ascending order
                    return a - b;
                }
            });

            // Step 4: Print the sorted list (to avoid duplicates)
            Set<Integer> printed = new HashSet<>();
            for (int num : list) {
                if (!printed.contains(num)) {
                    for (int i = 0; i < map.get(num); i++) {
                        System.out.print(num + " ");
                    }
                    printed.add(num);
                }
            }
            System.out.println(); // Move to the next line for each test case
        }

        sc.close();
	}
}