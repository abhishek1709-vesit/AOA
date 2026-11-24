import java.util.*;

class Item{
    int profit, weight;
    double ratio;

    Item(int profit, int weight){
        this.profit = profit;
        this.weight = weight;
        ratio = (double) profit / weight;
    }
}

public class FractionalKnapstack{
    public static void main(String[] args){

        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        int capacity = 50;

        Arrays.sort(items, (a,b) -> Double.compare(b.ratio, a.ratio));

        double totalProfit = 0;

        for(Item item : items){
            if(capacity == 0) break;

            if(item.weight <= capacity){
                totalProfit += item.profit;
                capacity -= item.weight;
            } else {
                totalProfit += item.ratio * capacity;
                capacity = 0;
            }
        }

        System.out.println("Total Profit is : "+ totalProfit);
    }
}