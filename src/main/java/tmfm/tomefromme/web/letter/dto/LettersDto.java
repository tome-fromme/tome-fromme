package tmfm.tomefromme.web.letter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

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
