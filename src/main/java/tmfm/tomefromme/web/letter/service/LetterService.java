package tmfm.tomefromme.web.letter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tmfm.tomefromme.domain.letter.entity.Letter;
import tmfm.tomefromme.web.letter.dto.LettersDto;
import tmfm.tomefromme.web.letter.repository.LetterRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LetterService {

    private final LetterRepository letterRepository;

    public void createLetter(LettersDto letterDto) {
        String uploadDir = "jiw";
        Letter letter = letterDto.toEntity();

        letterRepository.save(letter);

        //파일 작성기능 공통으로 빼기
        letterDto.getMultipartFileList().forEach(multipartFile -> {
            Path copyOfLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(multipartFile.getOriginalFilename()));
            try {
                Files.copy(multipartFile.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                //TODO
//                throw new BusinessException(ErrorCode.MEMBER_NOT_EXIST);
            }
        });
    }

    public void updateLetter(Long letterId, LettersDto lettersDto) {
        Letter letter = letterRepository.findById(letterId)
                .orElseThrow(NoSuchElementException::new);

        Letter updateLetter = lettersDto.updateLetter(letter);
        letterRepository.save(updateLetter);

        //부모에서 변경해도 변경은 되겠지만 ImgList도 따로 update 후 letter update로 변경
    }

    public void deleteLetter(Long letterId) {
        Letter letter = letterRepository.findById(letterId)
                .orElseThrow(NoSuchElementException::new);

        letterRepository.delete(letter);
    }
}
