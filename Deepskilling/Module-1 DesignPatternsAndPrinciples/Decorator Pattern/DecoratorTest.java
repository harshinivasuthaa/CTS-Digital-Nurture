package decorator;


public class DecoratorTest {
    public static void main(String[] args) {
        System.out.println("-- Email only --");
        Notifier emailOnly = new EmailNotifier();
        emailOnly.send("Server CPU usage is at 90%");

        System.out.println("\n-- Email + SMS --");
        Notifier emailAndSms = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSms.send("Database backup completed");

        System.out.println("\n-- Email + SMS + Slack --");
        Notifier all = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        all.send("Production deployment finished");
    }
}
