package tmfm.tomefromme.web.letter.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tmfm.tomefromme.global.config.security.UserDetailsImpl;
import tmfm.tomefromme.web.letter.dto.LettersDto;
import tmfm.tomefromme.web.letter.service.LettersService;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class LettersController {

    private final LettersService lettersService;

    //TODO - string query?
    @GetMapping("/letters")
    public ResponseEntity getLetters(@RequestParam(name="page", defaultValue="0") int page,
                                     @AuthenticationPrincipal UserDetailsImpl userDetails) {

        Long userId = userDetails.getUserId();
        Pageable pageable = PageRequest.of(page, 10);
        Page<LettersDto> lettersDtoPage = lettersService.getLetters(userId, pageable);

        return ResponseEntity.ok(lettersDtoPage);
    }
}
