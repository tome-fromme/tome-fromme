package tmfm.tomefromme.web.letter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tmfm.tomefromme.web.letter.dto.LettersDto;

public interface LettersRepositoryCustom {

    Page<LettersDto> getLetters(Long userId, Pageable pageable);
}
