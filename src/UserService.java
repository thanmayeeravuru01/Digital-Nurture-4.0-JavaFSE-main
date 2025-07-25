public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {  // ✅ Add this constructor
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
