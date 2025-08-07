package exercise4;

// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy 1
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card: " + cardNumber);
    }
}

// Concrete Strategy 2
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using PayPal: " + email);
    }
}

// Context
class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payAmount(int amount) {
        if (strategy == null) {
            System.out.println("Payment method not set.");
        } else {
            strategy.pay(amount);
        }
    }
}

// Client
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        context.payAmount(5000);

        // Switch to PayPal
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.payAmount(3000);
    }
}
