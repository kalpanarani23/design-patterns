package TemplatePattern.example1;

public class EmailNotification extends NotificationTemplate {
    @Override
    protected void prepareNotification() {
        System.out.println("Preparing Email Notification...");

    }

    @Override
    protected String createMessage() {
        return "This is an Email Notification...";
    }

    @Override
    protected void sendMessage(String message, String recipient) {
        System.out.println("Sending Email to " + recipient + " :" + message);

    }
}
