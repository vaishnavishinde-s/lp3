
public class MatrixMultiplication {

    static int[][] A = {{1, 2}, {3, 4}};
    static int[][] B = {{5, 6}, {7, 8}};
    static int[][] C = new int[2][2];
    static int[][] D = new int[2][2];

    static void display(int[][] M) {
        for (int[] row : M) {
            for (int x : row)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        // Single-thread multiplication
        long start = System.nanoTime();

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 2; k++)
                    C[i][j] += A[i][k] * B[k][j];

        long end = System.nanoTime();

        System.out.println("Single Thread Result:");
        display(C);
        long singleTime = end - start;

        // Multithreaded multiplication (one thread per row)
        start = System.nanoTime();

        Thread[] t = new Thread[2];

        for (int i = 0; i < 2; i++) {
            final int row = i;

            t[i] = new Thread(() -> {
                for (int j = 0; j < 2; j++)
                    for (int k = 0; k < 2; k++)
                        D[row][j] += A[row][k] * B[k][j];
            });

            t[i].start();
        }

        for (Thread thread : t)
            thread.join();

        end = System.nanoTime();

        System.out.println("\nMultithreaded Result:");
        display(D);

        System.out.println("\nSingle Thread Time: " + singleTime + " ns");
        System.out.println("Multithreaded Time: " + (end - start) + " ns");
    }
}
