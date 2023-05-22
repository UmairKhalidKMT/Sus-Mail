import java.util.Scanner;

public class SuspiciousEmailDetection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the email subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter the email content: ");
        String content = scanner.nextLine();

        boolean isSuspicious = checkSuspiciousEmail(subject, content);

        if (isSuspicious) {
            System.out.println("Suspicious email detected!");
        } else {
            System.out.println("Email seems fine.");
        }
    }

    private static boolean checkSuspiciousEmail(String subject, String content) {
        // Check for suspicious keywords in subject
        if (subject.contains("urgent") || subject.contains("payment") || subject.contains("account")) {
            return true;
        }

        // Check for suspicious patterns in content
        if (content.contains("Click the link below to claim your prize") || content.contains("You have won a lottery")) {
            return true;
        }

        // Check for excessive capitalization in content
        int uppercaseCount = 0;
        for (char c : content.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            }
        }
        double uppercaseRatio = (double) uppercaseCount / content.length();
        if (uppercaseRatio > 0.3) {
            return true;
        }

        // Check for presence of multiple exclamation marks
        int exclamationCount = 0;
        for (char c : content.toCharArray()) {
            if (c == '!') {
                exclamationCount++;
            }
        }
        if (exclamationCount > 3) {
            return true;
        }

        return false;
    }
}
