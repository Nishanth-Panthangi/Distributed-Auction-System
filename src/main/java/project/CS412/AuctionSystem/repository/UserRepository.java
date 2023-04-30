package project.CS412.AuctionSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.CS412.AuctionSystem.model.User;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
