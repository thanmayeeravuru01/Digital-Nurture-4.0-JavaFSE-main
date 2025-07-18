public class UserService {
    private Logger logger;

    public UserService(Logger logger) {
        this.logger = logger;
    }

    public void createUser(String username) {
        // pretend we're creating a user
        logger.log("User created: " + username);
    }
}
