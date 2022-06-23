package tmfm.tomefromme.web.letter.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tmfm.tomefromme.web.letter.dto.LettersDto;
import tmfm.tomefromme.web.letter.service.LetterService;

@RestController
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    @PostMapping("/letter")
    public void createLetter(@RequestParam LettersDto letter) {
        letterService.createLetter(letter);
    }

    @PutMapping("/letter/{letterId}")
    public void updateLetter(@PathVariable Long letterId, @RequestBody LettersDto lettersDto) {
        letterService.updateLetter(letterId, lettersDto);
    }

}
