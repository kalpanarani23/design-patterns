package loggingframework.simple;

import loggingframework.LogLevel;
import loggingframework.strategies.Appender;

import java.util.List;

public class Configuration {
    private LogLevel minLevel;
    private List<Appender> appenders;

    public Configuration(LogLevel minLevel, List<Appender> appenders) {
        this.minLevel = minLevel;
        this.appenders = appenders;
    }

    public LogLevel getMinLevel() {
        return minLevel;
    }

    public List<Appender> getAppenders() {
        return appenders;
    }
}
