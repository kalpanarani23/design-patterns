package TemplatePattern.example1;

public class SMSNotification extends NotificationTemplate {

    @Override
    protected void prepareNotification() {
        System.out.println("Preparing SMS Notification...");
    }

    @Override
    protected String createMessage() {
        return "This is a SMS notification..";
    }

    @Override
    protected void sendMessage(String message, String recipient) {
        System.out.println("Sending message to " + recipient + ":" + message);
    }
}
