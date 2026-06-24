public class ForecastTest {
    public static void main(String[] args) {
        double presentValue = 10000.0;
        double growthRate   = 0.08;
        int    years        = 5;

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println("Present Value : Rs. " + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.println();

        double recursiveResult = FinancialForecasting.calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Recursive  Future Value: Rs. %.2f%n", recursiveResult);

        double iterativeResult = FinancialForecasting.calculateFutureValueIterative(presentValue, growthRate, years);
        System.out.printf("Iterative  Future Value: Rs. %.2f%n", iterativeResult);

        System.out.println("\n=== Year-by-Year Breakdown ===");
        for (int y = 1; y <= years; y++) {
            double val = FinancialForecasting.calculateFutureValue(presentValue, growthRate, y);
            System.out.printf("Year %d: Rs. %.2f%n", y, val);
        }

        System.out.println("\n=== Scenario Comparison (Rs.10,000 over 10 years) ===");
        double[] rates = {0.05, 0.08, 0.12, 0.15};
        for (double rate : rates) {
            double fv = FinancialForecasting.calculateFutureValue(10000, rate, 10);
            System.out.printf("At %4.0f%% : Rs. %.2f%n", rate * 100, fv);
        }

        System.out.println("\nTime complexity: O(n) for both recursive and iterative");
        System.out.println("Space complexity: O(n) recursive (call stack), O(1) iterative");
    }
}
