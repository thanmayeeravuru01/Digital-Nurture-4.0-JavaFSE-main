package exercise1;

// Singleton class
class Singleton {
    // Private static instance
    private static Singleton instance;

    // Private constructor prevents instantiation from other classes
    private Singleton() {
        System.out.println("Singleton instance created!");
    }

    // Public method to return the same instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

public class SingletonExample {
    public static void main(String[] args) {
        // Try creating multiple instances
        Singleton obj1 = Singleton.getInstance();
        obj1.showMessage();

        Singleton obj2 = Singleton.getInstance();
        obj2.showMessage();

        // Check if both references point to the same object
        if (obj1 == obj2) {
            System.out.println("Both objects are the same instance.");
        } else {
            System.out.println("Different instances exist!");
        }
    }
}
