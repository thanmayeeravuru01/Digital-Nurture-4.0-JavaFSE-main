public class PrintService {
    private Printer printer;

    public PrintService(Printer printer) {
        this.printer = printer;
    }

    public void printWelcome() {
        printer.print("Welcome!");
    }

    public void printGoodbye() {
        printer.print("Goodbye!");
    }
}
