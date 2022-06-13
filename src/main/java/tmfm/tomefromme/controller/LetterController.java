package tmfm.tomefromme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tmfm.tomefromme.domain.letter.entity.Letter;
import tmfm.tomefromme.service.LetterService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LetterController {

    private final LetterService letterService;

    public LetterController(LetterService letterService) {
        this.letterService = letterService;
    }

    @PostMapping("/letter")
    public void createLetter(@RequestParam Letter letter, @RequestParam List<MultipartFile> multipartFileList) {
        letterService.createLetter(letter, multipartFileList);
    }

}
