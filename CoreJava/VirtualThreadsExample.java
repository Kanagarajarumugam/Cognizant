public class VirtualThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100_000;

        System.out.println("Starting virtual threads...");
        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = Thread.startVirtualThread(() -> {
                // System.out.println(Thread.currentThread().getName());
            });
        }

        for (Thread t : threads) {
            t.join();
        }

        long duration = System.currentTimeMillis() - start;
        System.out.println("All virtual threads completed in " + duration + " ms");
    }
}
