package tmfm.tomefromme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tmfm.tomefromme.domain.letter.entity.Letter;

public interface LetterRepository extends JpaRepository<Letter, Long> {
}
