package exercise6;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
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
        System.out.println(name + " received Email Notification: " + message);
    }
}

// Concrete Observer 2
class SMSSubscriber implements Observer {
    private String name;

    public SMSSubscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received SMS Alert: " + message);
    }
}

// Subject
class NewsAgency {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifySubscribers(String news) {
        for (Observer o : observers) {
            o.update(news);
        }
    }
}

// Main class
public class ObserverPatternExample {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer emailUser = new EmailSubscriber("Alice");
        Observer smsUser = new SMSSubscriber("Bob");

        agency.subscribe(emailUser);
        agency.subscribe(smsUser);

        agency.notifySubscribers("Breaking News: Observer Pattern Implemented!");
    }
}
