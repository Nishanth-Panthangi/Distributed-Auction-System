package project.CS412.AuctionSystem.repository;

import project.CS412.AuctionSystem.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String username);
}
