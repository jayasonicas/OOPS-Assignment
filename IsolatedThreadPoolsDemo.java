import java.util.concurrent.*;

public class IsolatedThreadPoolsDemo {

    // Separate thread pools for subsystems
    private static final ExecutorService dbPool =
            Executors.newFixedThreadPool(2); // DB subsystem

    private static final ExecutorService networkPool =
            Executors.newCachedThreadPool(); // Network subsystem

    private static final ScheduledExecutorService backgroundPool =
            Executors.newScheduledThreadPool(1); // Background subsystem

    public static void main(String[] args) {

        // Database task
        Runnable dbTask = () -> {
            System.out.println("Executing DB Task on: " + Thread.currentThread().getName());
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            System.out.println("DB Task Completed.");
        };

        // Network task
        Runnable networkTask = () -> {
            System.out.println("Executing Network Task on: " + Thread.currentThread().getName());
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            System.out.println("Network Task Completed.");
        };

        // Background task
        Runnable backgroundTask = () -> {
            System.out.println("Executing Background Task on: " + Thread.currentThread().getName());
        };

        // Submit tasks to their respective pools
        dbPool.submit(dbTask);
        networkPool.submit(networkTask);
        backgroundPool.schedule(backgroundTask, 1, TimeUnit.SECONDS);

        // Shutdown pools
        dbPool.shutdown();
        networkPool.shutdown();
        backgroundPool.shutdown();
    }
}
