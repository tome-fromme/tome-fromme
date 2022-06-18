package tmfm.tomefromme.web.letter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import tmfm.tomefromme.domain.letter.entity.Letter;

public interface LettersRepository extends JpaRepository<Letter, Long>,
        QuerydslPredicateExecutor<Letter>, LettersRepositoryCustom {
}
