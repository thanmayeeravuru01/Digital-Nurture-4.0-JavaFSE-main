public class AsyncMailer {
    private EmailClient emailClient;

    public AsyncMailer(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void send(String to, String message) {
        new Thread(() -> {
            try {
                Thread.sleep(100); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            emailClient.sendEmail(to, message);
        }).start();
    }
}
