package loggingframework.strategies.format;

import loggingframework.Message;

public interface Formatter {
    String logFormat(Message message);
}
