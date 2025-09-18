package loggingframework.strategies;


import loggingframework.Message;
import loggingframework.strategies.format.Formatter;

//common for diff destinations like console, file, database.
public interface Appender {
    void append(Message message);

    Formatter getFormatter();

    void close();

    void setFormatter(Formatter formatter);
}
