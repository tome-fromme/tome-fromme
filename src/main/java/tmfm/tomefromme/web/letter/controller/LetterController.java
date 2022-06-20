package tmfm.tomefromme.web.letter.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tmfm.tomefromme.domain.letter.entity.Letter;
import tmfm.tomefromme.web.letter.service.LetterService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    @PostMapping("/letter")
    public void createLetter(@RequestParam Letter letter, @RequestParam List<MultipartFile> multipartFileList) {
        //todo dto로 변경하고 crud 작업
        letterService.createLetter(letter, multipartFileList);
    }

}
