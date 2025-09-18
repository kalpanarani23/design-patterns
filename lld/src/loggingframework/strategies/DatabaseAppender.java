package loggingframework.strategies;

import loggingframework.Message;
import loggingframework.strategies.format.Formatter;

public class DatabaseAppender implements Appender {
    @Override
    public void append(Message message) {

    }

    @Override
    public Formatter getFormatter() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void setFormatter(Formatter formatter) {

    }
}
