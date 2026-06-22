public class ForecastTest {
    public static void main(String[] args) {

        double presentValue = 10000.0;  // Rs. 10,000 investment
        double growthRate   = 0.08;     // 8% annual growth
        int    years        = 5;        // 5 year forecast

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println("Present Value : Rs. " + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.println();

        // Recursive
        double recursiveResult = FinancialForecasting
            .calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Recursive  Future Value: Rs. %.2f%n", recursiveResult);

        // Iterative
        double iterativeResult = FinancialForecasting
            .calculateFutureValueIterative(presentValue, growthRate, years);
        System.out.printf("Iterative  Future Value: Rs. %.2f%n", iterativeResult);

        // Year by year breakdown
        System.out.println("\n=== Year-by-Year Breakdown ===");
        for (int y = 1; y <= years; y++) {
            double val = FinancialForecasting
                .calculateFutureValue(presentValue, growthRate, y);
            System.out.printf("Year %d: Rs. %.2f%n", y, val);
        }

        // Multiple scenarios
        System.out.println("\n=== Scenario Comparison (Rs.10,000 over 10 years) ===");
        double[] rates = {0.05, 0.08, 0.12, 0.15};
        for (double rate : rates) {
            double fv = FinancialForecasting
                .calculateFutureValue(10000, rate, 10);
            System.out.printf("At %4.0f%% : Rs. %.2f%n", rate * 100, fv);
        }

        // Complexity note
        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Recursive : O(n) time, O(n) space (call stack)");
        System.out.println("Iterative : O(n) time, O(1) space");
        System.out.println("For large n, iterative is more memory efficient");
    }
}
