// Grid.java
import java.util.Stack;

public class Grid {
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];

    /**
     * Flood fill, starting with the given row and column.
     */
    public void floodfill(int row, int column) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(row, column));

        int fillCount = 0;

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            int r = p.getRow();
            int c = p.getColumn();

            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE) {
                if (pixels[r][c] == 0) {
                    fillCount++;
                    pixels[r][c] = fillCount;

                    stack.push(new Pair(r - 1, c));
                    stack.push(new Pair(r, c + 1));
                    stack.push(new Pair(r + 1, c)); 
                    stack.push(new Pair(r, c - 1));
                }
            }
        }
    }

    @Override
    public String toString() {
        String r = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
