package loggingframework.strategies.format;

import loggingframework.Message;

public class SimpleTextFormat implements Formatter {

    @Override
    public String logFormat(Message message) {
        return String.format("%s [%s] %s - %s: %s \n",
                message.getTimestamp(),
                message.getThreadName(),
                message.getLogLevel(),
                message.getLoggerName(),
                message.getMessage());
    }
}
