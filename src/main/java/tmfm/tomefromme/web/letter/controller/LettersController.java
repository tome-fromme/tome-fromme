package tmfm.tomefromme.web.letter.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tmfm.tomefromme.domain.letter.entity.Letter;
import tmfm.tomefromme.global.security.UserDetailsImpl;
import tmfm.tomefromme.web.letter.dto.LettersDto;
import tmfm.tomefromme.web.letter.service.LettersService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class LettersController {

    private final LettersService lettersService;

    @GetMapping("/letters")
    public ResponseEntity getLetters(Optional<Integer> page,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {

        try {
            String userEmail = userDetails.getUsername();
            Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);
            Page<LettersDto> lettersDtoPage = lettersService.getLetters(userEmail, pageable);
            return ResponseEntity.ok(lettersDtoPage);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
