package tmfm.tomefromme.web.letter.service;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tmfm.tomefromme.domain.letter.entity.Letter;
import tmfm.tomefromme.global.error.exception.BusinessException;
import tmfm.tomefromme.global.error.exception.ErrorCode;
import tmfm.tomefromme.web.letter.dto.LettersDto;
import tmfm.tomefromme.web.letter.repository.LettersRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LettersService {

    private final LettersRepository lettersRepository;

    public Page<LettersDto> getLetters(String userEmail, Pageable pageable) {

        Page<LettersDto> lettersDtoPageable = lettersRepository.getLetters(userEmail, pageable);

        return lettersDtoPageable;
    }

}
