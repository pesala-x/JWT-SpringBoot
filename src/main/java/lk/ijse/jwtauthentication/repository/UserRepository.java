package lk.ijse.jwtauthentication.repository;

import lk.ijse.jwtauthentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String userName);
    boolean existsByEmail(String userName);
    int deleteByEmail(String userName);
}
