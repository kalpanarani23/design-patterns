package TemplatePattern.example1;

public abstract class NotificationTemplate {

    final void sendNotification(String recipient) {
        prepareNotification();
        String s = createMessage();
        sendMessage(s, recipient);
    }

    protected abstract void prepareNotification();

    protected abstract String createMessage();

    protected abstract void sendMessage(String message, String recipient);
}
