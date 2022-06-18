package tmfm.tomefromme.web.letter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tmfm.tomefromme.domain.letter.entity.Letter;
import tmfm.tomefromme.domain.letter.repository.LetterRepository;
import tmfm.tomefromme.domain.user.entity.User;
import tmfm.tomefromme.domain.user.repository.UserRepository;
import tmfm.tomefromme.global.error.exception.EntityNotFoundException;
import tmfm.tomefromme.global.error.exception.ErrorCode;
import tmfm.tomefromme.web.letter.dto.LettersDto;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LettersService {

    private final UserRepository userRepository;

    private final LetterRepository letterRepository;

    public LettersDto getLetters(String userEmail) throws IOException {

        User user = userRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.MEMBER_NOT_EXIST));

        List<Letter> letters = letterRepository.findAllByUser(user);

        //TODO
        LettersDto lettersDto = LettersDto.builder().build();

        return lettersDto;

    }
}
