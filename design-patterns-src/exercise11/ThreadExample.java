package exercise11;

class MyTask implements Runnable {
    private String taskName;

    public MyTask(String name) {
        this.taskName = name;
    }

    @Override
    public void run() {
        System.out.println(taskName + " started");
        try {
            Thread.sleep(1000); // simulate some work
        } catch (InterruptedException e) {
            System.out.println(taskName + " interrupted");
        }
        System.out.println(taskName + " completed");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask("Task 1"));
        Thread t2 = new Thread(new MyTask("Task 2"));
        Thread t3 = new Thread(new MyTask("Task 3"));

        t1.start();
        t2.start();
        t3.start();

        System.out.println("All tasks started...");
    }
}
