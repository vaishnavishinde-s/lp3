
import java.util.*;

class Item {
    int profit, weight;
    double ratio;

    Item(int p, int w) {
        profit = p;
        weight = w;
        ratio = (double) p / w;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {

        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        int capacity = 50;
        double totalProfit = 0;

        Arrays.sort(items,
            Comparator.comparingDouble((Item i) -> i.ratio).reversed());

        System.out.println("Item\tProfit\tWeight\tRatio\tSelected");

        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            String selected;

            if (capacity == 0) {
                selected = "Not selected";
            }
            else if (item.weight <= capacity) {
                capacity -= item.weight;
                totalProfit += item.profit;
                selected = "Fully selected";
            }
            else {
                double fraction = (double) capacity / item.weight;
                totalProfit += item.profit * fraction;
                selected = (fraction * 100) + "% selected";
                capacity = 0;
            }

            System.out.println((i + 1) + "\t" + item.profit +
                "\t" + item.weight + "\t" + item.ratio +
                "\t" + selected);
        }

        System.out.println("\nMaximum Profit: " + totalProfit);
    }
}
