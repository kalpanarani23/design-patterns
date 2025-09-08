package TemplatePattern.example1;

public class Demo {
    public static void main(String[] args) {
        NotificationTemplate emailNotify = new EmailNotification();
        emailNotify.sendNotification("Kakashi@leaf.village.com");

        NotificationTemplate smsNotify = new SMSNotification();
        smsNotify.sendNotification("GOJO@jj.com");
    }
}
