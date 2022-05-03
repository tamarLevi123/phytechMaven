
public class TestImpl {

    public static Integer findBestProfit(int[] goldPrices) {
        if (goldPrices == null || goldPrices.length == 0) {
            return 0;
        }
        int buy = goldPrices[0];//20
        int sell = goldPrices[0];//20
        int profit = 0;//210
        for (int i = 1; i < goldPrices.length; i++) {
            if (goldPrices[i] < sell) {
                profit += sell - buy;
                buy = goldPrices[i];
                sell = goldPrices[i];
            }
            if (goldPrices[i] < buy) {
                buy = goldPrices[i];
            } else if (goldPrices[i] > sell) {
                sell = goldPrices[i];
            }

        }
        if (sell > buy) {
            profit += sell - buy;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] input = {20, 70, 140, 90, 180, 20, 30};
        System.out.println(findBestProfit(input) + "");
    }
}