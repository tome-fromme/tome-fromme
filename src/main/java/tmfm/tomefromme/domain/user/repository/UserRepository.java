package tmfm.tomefromme.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tmfm.tomefromme.domain.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository {

    Optional<User> findByUserEmail(String userEmail);
}
