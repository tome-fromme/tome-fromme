package tmfm.tomefromme.web.letter.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tmfm.tomefromme.web.letter.dto.LettersDto;
import tmfm.tomefromme.web.letter.service.LetterService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class LetterController {

    private final LetterService letterService;

    @PostMapping("/letters")
    public void createLetter(@RequestBody LettersDto letter) {
        letterService.createLetter(letter);
    }

    @PutMapping("/letters/{letterId}")
    public void updateLetter(@PathVariable Long letterId, @RequestBody LettersDto lettersDto) {
        letterService.updateLetter(letterId, lettersDto);
    }

    @DeleteMapping("/letters/{letterId}")
    public void deleteLetter(@PathVariable Long letterId) {
        letterService.deleteLetter(letterId);
    }


}
