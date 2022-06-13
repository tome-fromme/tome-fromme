package tmfm.tomefromme.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tmfm.tomefromme.domain.letter.entity.Letter;
import tmfm.tomefromme.global.exception.SomeException;
import tmfm.tomefromme.global.exception.SomethingResult;
import tmfm.tomefromme.repository.LetterRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class LetterService {

    private final LetterRepository letterRepository;

    public LetterService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    @Transactional
    public void createLetter(Letter letter, List<MultipartFile> multipartFileList) {
        String uploadDir = "jiw";

        letterRepository.save(letter);

        multipartFileList.forEach(multipartFile -> {
            Path copyOfLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(multipartFile.getOriginalFilename()));
            try {
                Files.copy(multipartFile.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new SomeException("저장 중 에러발생", 999);
            }
        });
    }
}
