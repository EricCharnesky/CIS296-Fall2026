
public class Main {

    // Initialize balance to 100
    private static int balance = 100;

    public static void main() {
        // from https://link.springer.com/chapter/10.1007/978-1-4842-7135-3_5
        Runnable aRunnableObject = () -> System.out.println("Hello Java threads!");

        Thread exampleThread = new Thread(aRunnableObject);
        exampleThread.start();


        // Create two Thread objects
        Thread t1 = new Thread(Main::print);
        Thread t2 = new Thread(Main::print);
        // Start both threads
//        t1.start();
//        t2.start();

        startBalanceUpdateThread();
        // <- Thread to update the balance value
        startBalanceMonitorThread();
        // <- Thread to monitor the balance value




    }

    public static void updateBalance() {
        // Add 10 to balance and subtract 10 from balance
        balance = balance + 10;
        balance = balance - 10;
        System.out.println("updated");
    }
    public static void monitorBalance() {
        int b = balance;
        if (b != 100) {
            System.out.println("Balance changed: " + b);
            System.exit(0); // Exit the program
        }
    }
    public static void startBalanceUpdateThread() {
        // Start a new thread that calls the
        // updateBalance() method in an infinite loop
        Thread t = new Thread(() -> {
            while (true) {
                updateBalance();
            }
        });
        t.start();
    }
    public static void startBalanceMonitorThread() {
        // Start a thread that monitors the balance value
        Thread t = new Thread(() -> {
            while (true) {
                monitorBalance();
            }
        });
        t.start();
    }

    public static void print() {
        for (int i = 1; i <= 500; i++) {
            System.out.println(i);
        }
    }
}


