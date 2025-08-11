public class NotificationService {
    private Messenger messenger;

    public NotificationService(Messenger messenger) {
        this.messenger = messenger;
    }

    public void alertUser() {
        messenger.sendMessage("Hello from system!");
    }
}
