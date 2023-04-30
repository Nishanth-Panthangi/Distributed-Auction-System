package project.CS412.AuctionSystem.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.CS412.AuctionSystem.model.Role;
import project.CS412.AuctionSystem.model.User;
import project.CS412.AuctionSystem.repository.UserRepository;
import project.CS412.AuctionSystem.security.UserDetailsImpl;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userRepository.findByUsername(username);
        }catch (Exception e){
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
        return new UserDetailsImpl(user);
    }

    public User registerUser(User user) {
        user.setRole(Role.BIDDER); // Set default role as BIDDER
        return userRepository.save(user);
    }
}



