package tmfm.tomefromme.web.letter.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tmfm.tomefromme.global.security.UserDetailsImpl;
import tmfm.tomefromme.web.letter.dto.LettersDto;
import tmfm.tomefromme.web.letter.service.LettersService;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class LettersController {

    private final LettersService lettersService;

    @GetMapping("/letters")
    public ResponseEntity getLetters(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        String userEmail = userDetails.getUsername();
        try {
            LettersDto lettersDto = lettersService.getLetters(userEmail);
            return ResponseEntity.ok(lettersDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
