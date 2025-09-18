package loggingframework;

import loggingframework.strategies.Appender;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncLogProcessor {

    private final ExecutorService executorService;

    public AsyncLogProcessor() {
        this.executorService = Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable, "AsyncLogProcessor");
            thread.setDaemon(true);
            return thread;
        });
    }


    public void process(Message logMessage, List<Appender> appenders) {
        if (executorService.isShutdown()) {
            System.err.println("Logger is shut down. Cannot process log message.");
            return;
        }

        // Submit a new task to the executor.
        executorService.submit(() -> {
            for (Appender appender : appenders) {
                appender.append(logMessage);
            }
        });
    }

    public void stop() {
        // Disable new tasks from being submitted
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
                System.err.println("Logger executor did not terminate in the specified time.");
                // Forcibly shut down any still-running tasks.
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
