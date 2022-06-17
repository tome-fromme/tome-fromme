package tmfm.tomefromme.web.letter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tmfm.tomefromme.web.letter.dto.LettersDto;
import tmfm.tomefromme.web.letter.repository.LettersRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LettersService {

    private final LettersRepository lettersRepository;

    public Page<LettersDto> getLetters(String userEmail, Pageable pageable) throws IOException {

        Page<LettersDto> lettersDtoPageable = lettersRepository.getLetters(userEmail, pageable);

        return lettersDtoPageable;

    }
}
