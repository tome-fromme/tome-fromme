package tmfm.tomefromme.web.letter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import tmfm.tomefromme.domain.letter.entity.Letter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class LettersDto {

    private Long letterId;

    private String letterTitle;

    private String letterContent;

    private LocalDateTime letterOpenDay;

    private String letterSendYn;

    private String useYn;

    private String locationX;

    private String locationY;

    private String locationName;

    private String locationId;

    private List<LetterImgDto> letterImgDtos;

    private List<MultipartFile> multipartFileList;

    public Letter toEntity() {
        return Letter.builder()
                .letterTitle(this.letterTitle)
                .letterContent(this.letterContent)
                .letterOpenDay(this.letterOpenDay)
                .letterSendYn(this.letterSendYn)
                .useYn(this.useYn)
                .locationX(this.locationX)
                .locationY(this.locationY)
                .locationName(this.locationName)
                .locationId(this.locationId)
                .build();
    }

    public Letter updateLetter(Letter letter) {
        return Letter.builder()
                .id(letter.getId())
                .letterTitle(this.letterTitle)
                .letterContent(this.letterContent)
                .useYn(this.useYn)
                .build();
    }

    @Getter
    @Setter
    @Builder
    public static class LetterImgDto {

        private Long letterImgId;

        private String originalImgName;

        private String savedImgName;

        private String imgUrl;

    }

}
