package tmfm.tomefromme.web.letter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tmfm.tomefromme.web.letter.dto.LettersDto;
import tmfm.tomefromme.web.letter.repository.LettersRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LettersService {

    private final LettersRepository lettersRepository;

    public Page<LettersDto> getLetters(Long userId, Pageable pageable) {

        Page<LettersDto> lettersDtoPageable = lettersRepository.getLetters(userId, pageable);

        return lettersDtoPageable;

    }
}
