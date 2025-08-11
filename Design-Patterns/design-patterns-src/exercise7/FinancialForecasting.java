package exercise7;

public class FinancialForecasting {

    // Recursive method to predict future value
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized version using loop to avoid deep recursion
    public static double predictFutureValueIterative(double currentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            currentValue *= (1 + growthRate);
        }
        return currentValue;
    }

    public static void main(String[] args) {
        double currentValue = 1000.0;  // Starting amount
        double growthRate = 0.05;      // 5% annual growth
        int years = 5;

        // Recursive prediction
        double futureValueRecursive = predictFutureValue(currentValue, growthRate, years);
        System.out.println("Predicted Future Value (Recursive): $" + futureValueRecursive);

        // Iterative prediction
        double futureValueIterative = predictFutureValueIterative(currentValue, growthRate, years);
        System.out.println("Predicted Future Value (Iterative): $" + futureValueIterative);
    }
}
