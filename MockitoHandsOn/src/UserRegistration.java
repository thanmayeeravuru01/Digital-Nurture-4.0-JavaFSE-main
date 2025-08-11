public class UserRegistration {
    private EmailService emailService;

    public UserRegistration(EmailService emailService) {
        this.emailService = emailService;
    }

    public boolean registerUser(String email) {
        try {
            emailService.sendEmail(email, "Welcome!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
