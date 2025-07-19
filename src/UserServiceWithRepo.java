public class UserServiceWithRepo {
    private final UserRepository userRepository;

    public UserServiceWithRepo(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(Long id) {
        User user = userRepository.findById(id);
        return user != null ? user.getName() : "Unknown";
    }
}
