//Given a binary grid[][], where each cell contains either 0 or 1, find the distance of the nearest 1 for every cell in the grid
//The distance between two cells (i1, j1)  and (i2, j2) is calculated as |i1 - i2| + |j1 - j2|. 
//You need to return a matrix of the same size, where each cell (i, j) contains the minimum distance from grid[i][j] to the nearest cell having value 1.
//Approach: Multi-Source BFS
/* 
 2. Instead of finding nearest 1 for each 0 (which is slow),

       we start BFS from all 1s simultaneously.

    3. Steps:

       - Push all cells having value 1 into queue

       - Mark their distance = 0

       - Mark all 0 cells as unvisited (-1)

    4. Perform BFS:

       - Pop a cell

       - Visit its 4 neighbors

       - If neighbor is unvisited:

           dist = current distance + 1

           push into queue

    5. BFS ensures shortest distance because:

       - It explores level by level

       - First time reaching a cell gives minimum distance
*/

import java.util.*;

class Dist_Of_Nearest_Cell_Having_1 {

    public int[][] nearest(int[][] grid) {

        int n = grid.length;        // number of rows
        int m = grid[0].length;     // number of columns

        int[][] dist = new int[n][m];   // result matrix
        Queue<int[]> q = new LinkedList<>(); // queue for BFS

        // -------------------------------
        // STEP 1: INITIALIZATION
        // -------------------------------
        // Push all '1' cells into queue
        // Mark them as distance = 0
        // Mark all '0' cells as unvisited (-1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    dist[i][j] = 0;                 // distance to itself is 0
                    q.offer(new int[]{i, j});       // add to queue (multi-source BFS)
                } else {
                    dist[i][j] = -1;                // not visited yet
                }
            }
        }

        // -------------------------------
        // STEP 2: DIRECTIONS (4 SIDES)
        // -------------------------------
        // Used to move: Up, Down, Left, Right
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};

        // -------------------------------
        // STEP 3: BFS TRAVERSAL
        // -------------------------------
        while (!q.isEmpty()) {

            int[] curr = q.poll();   // remove front element
            int r = curr[0];         // current row
            int c = curr[1];         // current column

            // explore all 4 directions
            for (int i = 0; i < 4; i++) {

                int nr = r + drow[i];   // new row
                int nc = c + dcol[i];   // new column

                // check:
                // 1. inside grid
                // 2. not visited yet (dist == -1)
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && dist[nr][nc] == -1) {

                    // assign distance = parent distance + 1
                    dist[nr][nc] = dist[r][c] + 1;

                    // push neighbor into queue
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // -------------------------------
        // STEP 4: RETURN RESULT
        // -------------------------------
        return dist;
    }

     public static void main(String[] args) {

        Dist_Of_Nearest_Cell_Having_1 obj = new Dist_Of_Nearest_Cell_Having_1();

        int[][] grid = {

            {0, 1, 1, 0},

            {1, 1, 0, 0},

            {0, 0, 1, 1}

        };

        int[][] result = obj.nearest(grid);

        // Print result

        System.out.println("Distance Matrix:");

        for (int i = 0; i < result.length; i++) {

            for (int j = 0; j < result[0].length; j++) {

                System.out.print(result[i][j] + " ");

            }

            System.out.println();

        }

    }

}
