package tmfm.tomefromme.domain.letter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tmfm.tomefromme.domain.letter.entity.Letter;
import tmfm.tomefromme.domain.user.entity.User;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {

    List<Letter> findAllByUser(User user);
}
