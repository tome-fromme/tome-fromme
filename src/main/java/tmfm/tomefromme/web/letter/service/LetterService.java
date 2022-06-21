package tmfm.tomefromme.web.letter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tmfm.tomefromme.domain.letter.entity.Letter;
import tmfm.tomefromme.web.letter.dto.LettersDto;
import tmfm.tomefromme.web.letter.repository.LetterRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LetterService {

    private final LetterRepository letterRepository;

    public void createLetter(LettersDto letter) {
        String uploadDir = "jiw";

        letterRepository.save(letter);

        //파일 작성기능 공통으로 빼기
        letter.getMultipartFileList().forEach(multipartFile -> {
            Path copyOfLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(multipartFile.getOriginalFilename()));
            try {
                Files.copy(multipartFile.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                //TODO
//                throw new BusinessException(ErrorCode.MEMBER_NOT_EXIST);
            }
        });
    }
}
