package loggingframework;

import java.time.LocalDateTime;

public class Message {
    private LogLevel logLevel;
    private final String message;
    private final String threadName;
    private final String loggerName;
    private LocalDateTime timestamp;

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getMessage() {
        return message;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Message(LogLevel logLevel, String message, String loggerName) {
        this.logLevel = logLevel;
        this.message = message;
        this.threadName = Thread.currentThread().getName();
        this.loggerName = loggerName;
        this.timestamp = LocalDateTime.now();
    }
}
