package loggingframework.strategies;

import loggingframework.Message;
import loggingframework.strategies.format.Formatter;
import loggingframework.strategies.format.SimpleTextFormat;

public class ConsoleAppender implements Appender {
    private Formatter formatter;
    public ConsoleAppender() {
        this.formatter = new SimpleTextFormat(); // Initialize with default formatter
    }

    // Constructor with custom formatter
    public ConsoleAppender(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void append(Message message) {
        if (formatter != null) {
            System.out.println(formatter.logFormat(message));
        } else {
            // Fallback if formatter is still null
            System.out.println("[" + message.getLogLevel() + "] " + message.getMessage());
        }
    }

    @Override
    public Formatter getFormatter() {
        return formatter;
    }

    @Override
    public void close() {

    }

    @Override
    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }
}
