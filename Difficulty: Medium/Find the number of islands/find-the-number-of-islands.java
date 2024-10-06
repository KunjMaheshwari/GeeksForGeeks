//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
        scanner.close();
    }
}

// } Driver Code Ends




class Solution {
    private static final int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    private void bfs(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0'; 

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            
            for (int d = 0; d < 8; d++) {
                int newRow = x + rowDir[d];
                int newCol = y + colDir[d];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1') {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';  
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int islandCount = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    bfs(grid, i, j);
                }
            }
        }

        return islandCount;
    }
}