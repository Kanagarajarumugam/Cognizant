class MessageThread extends Thread {
    private String message;

    public MessageThread(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(message + " - " + (i + 1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class ThreadCreationExample {
    public static void main(String[] args) {
        MessageThread thread1 = new MessageThread("Thread 1 message");
        MessageThread thread2 = new MessageThread("Thread 2 message");

        thread1.start();
        thread2.start();
    }
}
