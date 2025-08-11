public class Notifier {
    private MessageSender sender;

    public Notifier(MessageSender sender) {
        this.sender = sender;
    }

    public void notifyUser(String userId) {
        sender.send(userId, "You have a new notification.");
    }
}
