package loggingframework.simple;

import loggingframework.LogLevel;
import loggingframework.Message;
import loggingframework.strategies.Appender;

public class Logger {
    private final String name;
    Configuration configuration;

    public Logger(String name, Configuration configuration) {
        this.name = name;
        this.configuration = configuration;
    }

    public void log(LogLevel logLevel, String message) {
        if (logLevel.isGreaterOrEqual(logLevel)) {
            Message message1 = new Message(logLevel, message, this.name);
            for (Appender appender : configuration.getAppenders()) {
                appender.append(message1);
            }
        }
    }


    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
