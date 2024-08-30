//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Sorting jobs in descending order of profit
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        // To keep track of free time slots
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        int[] slot = new int[maxDeadline]; // To keep track of free time slots
        Arrays.fill(slot, -1); // Initialize all slots to be free

        int totalProfit = 0;
        int count = 0;

        // Iterate through all jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (we start from the last possible slot)
            for (int j = arr[i].deadline - 1; j >= 0; j--) {
                // If slot is free
                if (slot[j] == -1) {
                    slot[j] = arr[i].id; // Assign the job to this slot
                    totalProfit += arr[i].profit;
                    count++;
                    break;
                }
            }
        }

        return new int[]{count, totalProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

*/