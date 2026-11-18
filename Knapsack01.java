
public class Knapsack01 {
    public static void main(String[] args) {

        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50, n = profit.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weight[i-1] <= w)
                    dp[i][w] = Math.max(dp[i-1][w],
                        profit[i-1] + dp[i-1][w-weight[i-1]]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }

        System.out.println("Maximum Profit: " + dp[n][capacity]);

        int w = capacity;
        System.out.println("\nSelected Items:");

        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i-1][w]) {
                System.out.println("Item " + i + " - Profit: "
                    + profit[i-1] + ", Weight: " + weight[i-1]);
                w -= weight[i-1];
            }
        }
    }
}
