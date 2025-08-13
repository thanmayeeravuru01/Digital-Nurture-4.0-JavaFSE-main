public class UserServiceWithRepo {

    private UserRepository userRepository;

    public UserServiceWithRepo(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(Long id) {
        User user = userRepository.findById(id).orElse(null); // ✅ Fix here
        return user != null ? user.getName() : null;
    }

    // Optional: you can also add this method if you want to reuse
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
