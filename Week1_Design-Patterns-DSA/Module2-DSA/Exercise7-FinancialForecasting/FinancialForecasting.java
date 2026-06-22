public class FinancialForecasting {

    // Recursive method - calculates future value
    // Base case: 0 years left → return present value
    // Recursive case: grow by rate, reduce years by 1
    public static double calculateFutureValue(double presentValue, 
                                               double growthRate, 
                                               int years) {
        // Base case
        if (years == 0) {
            return presentValue;
        }
        // Recursive case
        return calculateFutureValue(presentValue * (1 + growthRate), 
                                    growthRate, 
                                    years - 1);
    }

    // Iterative version - for comparison
    public static double calculateFutureValueIterative(double presentValue,
                                                        double growthRate,
                                                        int years) {
        double result = presentValue;
        for (int i = 0; i < years; i++) {
            result = result * (1 + growthRate);
        }
        return result;
    }
}
