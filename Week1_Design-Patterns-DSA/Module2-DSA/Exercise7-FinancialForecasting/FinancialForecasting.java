public class FinancialForecasting {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        double result = presentValue;
        for (int i = 0; i < years; i++) {
            result = result * (1 + growthRate);
        }
        return result;
    }
}
