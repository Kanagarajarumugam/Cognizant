import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;

public class ExecutorCallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(() -> "Task 1 result");
        tasks.add(() -> "Task 2 result");
        tasks.add(() -> "Task 3 result");

        List<Future<String>> futures = new ArrayList<>();
        for (Callable<String> task : tasks) {
            futures.add(executor.submit(task));
        }

        for (Future<String> future : futures) {
            String result = future.get();
            System.out.println(result);
        }

        executor.shutdown();
    }
}
