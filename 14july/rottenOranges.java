import java.util.*;

public class Main {

    public static int rottenOranges(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int minutes = 0;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < m &&
                        newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        System.out.println(rottenOranges(grid));
    }
}
