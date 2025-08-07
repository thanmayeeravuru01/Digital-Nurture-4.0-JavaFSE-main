package exercise7;

// Strategy Interface
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
        System.out.println("Paid ₹" + amount + " using Credit Card ending with " + cardNumber.substring(cardNumber.length() - 4));
    }
}

// Concrete Strategy 2
class UpiPayment implements PaymentStrategy {
    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using UPI ID: " + upiId);
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int amount) {
        if (strategy == null) {
            System.out.println("No payment strategy selected.");
            return;
        }
        strategy.pay(amount);
    }
}

// Main class
public class StrategyPatternExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay using Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234567812345678"));
        cart.checkout(5000);

        // Pay using UPI
        cart.setPaymentStrategy(new UpiPayment("user@upi"));
        cart.checkout(2000);
    }
}
