package tmfm.tomefromme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tmfm.tomefromme.domain.letter.entity.Letter;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Long> {
}
