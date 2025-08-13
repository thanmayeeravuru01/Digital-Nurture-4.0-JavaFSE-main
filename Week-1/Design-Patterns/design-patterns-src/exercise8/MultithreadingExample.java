package exercise8;

// Runnable implementation
class MessagePrinter implements Runnable {
    private String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message + " - Count: " + i);
            try {
                Thread.sleep(500); // sleep for 0.5 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class MultithreadingExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MessagePrinter("Thread A"));
        Thread thread2 = new Thread(new MessagePrinter("Thread B"));

        thread1.start();
        thread2.start();
    }
}
