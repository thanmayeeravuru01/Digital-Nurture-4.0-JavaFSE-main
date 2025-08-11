package exercise3;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String message);
}

// Concrete Observer 1
class EmailSubscriber implements Observer {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received EMAIL: " + message);
    }
}

// Concrete Observer 2
class SMSSubscriber implements Observer {
    private String name;

    public SMSSubscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received SMS: " + message);
    }
}

// Subject
class NotificationService {
    private List<Observer> subscribers = new ArrayList<>();

    public void subscribe(Observer o) {
        subscribers.add(o);
    }

    public void unsubscribe(Observer o) {
        subscribers.remove(o);
    }

    public void notifyAllSubscribers(String message) {
        for (Observer o : subscribers) {
            o.update(message);
        }
    }
}

// Client
public class ObserverPatternExample {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        Observer user1 = new EmailSubscriber("Alice");
        Observer user2 = new SMSSubscriber("Bob");

        service.subscribe(user1);
        service.subscribe(user2);

        service.notifyAllSubscribers("New product launch!");

        service.unsubscribe(user2);

        service.notifyAllSubscribers("Discount offer!");
    }
}
