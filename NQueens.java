
public class NQueens {
    static int N = 4;
    static int[][] board = new int[N][N];

    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;

        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        for (int i = row-1, j = col+1; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }

    static boolean solve(int row) {
        if (row == N) return true;

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;

                if (solve(row + 1)) return true;

                board[row][col] = 0;
            }
        }
        return false;
    }

    static void display() {
        System.out.println("N-Queens Matrix:");

        for (int[] row : board) {
            for (int x : row)
                System.out.print(x + " ");
            System.out.println();
        }

        System.out.println("\nChessboard:");

        for (int[] row : board) {
            for (int x : row)
                System.out.print(x == 1 ? "Q " : ". ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (solve(0))
            display();
        else
            System.out.println("No solution exists.");
    }
}
