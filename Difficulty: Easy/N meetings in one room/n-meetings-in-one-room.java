//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int maxMeetings(int[] start, int[] end) {
        // Create a 2D array to store start, end times, and original indices
        int meetings[][] = new int[start.length][3];
        
        for (int i = 0; i < start.length; i++) {
            meetings[i][0] = i;       // Index
            meetings[i][1] = start[i]; // Start time
            meetings[i][2] = end[i];   // End time
        }
        
        // Sort the meetings by end time (primary) and start time (secondary, optional for ties)
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[2]));
        
        // Initialize counters
        int maxMeetings = 1; // First meeting is always counted
        int lastEndMeeting = meetings[0][2]; // End time of the first meeting
        
        // Iterate through remaining meetings, starting from the second
        for (int i = 1; i < start.length; i++) {
            // If the current meeting starts after or when the last meeting ends
            if (meetings[i][1] > lastEndMeeting) {
                maxMeetings++;
                lastEndMeeting = meetings[i][2]; // Update the last attended meeting's end time
            }
        }
        
        return maxMeetings;
    }
}

