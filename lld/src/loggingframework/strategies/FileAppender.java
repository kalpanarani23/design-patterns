package loggingframework.strategies;

import loggingframework.Message;
import loggingframework.strategies.format.Formatter;
import loggingframework.strategies.format.SimpleTextFormat;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements Appender {
    private Formatter formatter;
    private FileWriter fileWriter;

    public FileAppender(String filePath) throws IOException {
        this.formatter = new SimpleTextFormat();
        try {
            this.fileWriter = new FileWriter(filePath);
        } catch (Exception e) {
            System.out.println("Failed to create writer for file logs : " + e.getMessage());
        }
    }

    @Override
    public void append(Message message) {
        try {
            fileWriter.write(formatter.logFormat(message) + "\n");
            fileWriter.flush();
        } catch (Exception e) {
            System.out.println("Failed to write logs :" + e.getMessage());
        }
    }

    @Override
    public Formatter getFormatter() {
        return formatter;
    }

    @Override
    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Failed to close logs file, exception: " + e.getMessage());
        }
    }

    @Override
    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }
}
