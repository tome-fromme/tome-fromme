package tmfm.tomefromme.web.letter.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import tmfm.tomefromme.domain.letter.entity.QLetter;
import tmfm.tomefromme.web.letter.dto.LettersDto;

import javax.persistence.EntityManager;
import java.util.List;

public class LettersRepositoryCustomImpl implements LettersRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public LettersRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<LettersDto> getLetters(Long userId, Pageable pageable) {

        QLetter letter = QLetter.letter;

        List<LettersDto> results = queryFactory
                .select(Projections.fields(LettersDto.class,
                        letter.id.as("id"),
                        letter.letterTitle.as("letterTitle"),
                        letter.letterContent.as("letterContent"),
                        letter.letterOpenDay.as("letterOpenDay"),
                        letter.letterSendYn.as("letterSendYn")))
                .from(letter)
                .where(letter.user.id.eq(userId))
                .orderBy(letter.id.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int totalSize = queryFactory
                .select(Projections.fields(LettersDto.class,
                        letter.id.as("id"),
                        letter.letterTitle.as("letterTitle"),
                        letter.letterContent.as("letterContent"),
                        letter.letterOpenDay.as("letterOpenDay"),
                        letter.letterSendYn.as("letterSendYn")))
                .from(letter)
                .where(letter.user.id.eq(userId))
                .fetch().size();

        return new PageImpl<>(results, pageable, totalSize);
    }
}
