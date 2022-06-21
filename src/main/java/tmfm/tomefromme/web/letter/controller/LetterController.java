package tmfm.tomefromme.web.letter.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tmfm.tomefromme.web.letter.dto.LettersDto;
import tmfm.tomefromme.web.letter.service.LetterService;

@RestController
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    @PostMapping("/letter")
    public void createLetter(@RequestParam LettersDto letter) {
        //todo letter -> entity로 변경하고 crud 작업
        letterService.createLetter(letter);
    }

}
