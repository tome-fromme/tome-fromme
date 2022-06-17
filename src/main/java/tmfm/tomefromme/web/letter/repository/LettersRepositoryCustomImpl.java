package tmfm.tomefromme.web.letter.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tmfm.tomefromme.web.letter.dto.LettersDto;

import javax.persistence.EntityManager;

public class LettersRepositoryCustomImpl implements LettersRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public LettersRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<LettersDto> getLetters(String userEmail, Pageable pageable) {
        return null;
    }
}
