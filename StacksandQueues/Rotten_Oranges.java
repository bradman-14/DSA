import java.util.*;

class Rotten_Oranges {

    /*
    ===================== LOGIC =====================

Given a matrix mat[][], where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cell have fresh oranges
2 : Cell have rotten oranges

Your task is to determine the minimum time required so that all the oranges become rotten. A rotten orange at index (i, j) can rot other fresh orange at indexes (i-1, j), (i+1, j), (i, j-1), (i, j+1) (up, down, left and right) in a unit time.

Approach: Multi-Source BFS

    1. Rotten oranges (2) act as sources
    2. Each minute, they rot adjacent fresh oranges (1)
    3. Use BFS to simulate spreading

    Steps:
    - Add all rotten oranges to queue with time = 0
    - Count fresh oranges
    - Perform BFS:
        - For each rotten orange, check 4 directions
        - If fresh orange found:
            → mark it rotten
            → push into queue with time + 1
            → decrease fresh count
    - Track maximum time

    If fresh oranges remain → return -1
    Else return total time

    Time Complexity: O(n * m)
    Space Complexity: O(n * m)

    =================================================
    */

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Initialize queue and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0}); // row, col, time
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        // Directions
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};

        // Step 2: BFS
        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];

            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {

                int nr = r + drow[i];
                int nc = c + dcol[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {

                    grid[nr][nc] = 2; // mark as rotten
                    q.offer(new int[]{nr, nc, t + 1});
                    fresh--;
                }
            }
        }

        // Step 3: Check if any fresh orange left
        if (fresh > 0) return -1;

        return time;
    }

    // -------------------------------
    // MAIN FUNCTION
    // -------------------------------
    public static void main(String[] args) {

        Rotten_Oranges obj = new Rotten_Oranges();

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = obj.orangesRotting(grid);

        System.out.println("Minimum Time: " + result);
    }
}