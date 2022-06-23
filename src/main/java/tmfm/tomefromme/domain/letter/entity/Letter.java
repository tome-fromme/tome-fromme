package tmfm.tomefromme.domain.letter.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tmfm.tomefromme.domain.base.BaseEntity;
import tmfm.tomefromme.domain.letterImg.entity.LetterImg;
import tmfm.tomefromme.domain.user.entity.User;
import tmfm.tomefromme.web.letter.dto.LettersDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Letter extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String letterTitle;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String letterContent;

    @Column(nullable = false)
    private LocalDateTime letterOpenDay;

    @Column(nullable = false, length = 2)
    private String letterSendYn;

    @Column(nullable = false, length = 2)
    private String useYn;

    private String locationX;
    private String locationY;
    private String locationName;
    private String locationId;

    @OneToMany(mappedBy = "letter")
    private List<LetterImg> letterImgList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Builder
    public Letter(Long id, String letterTitle, String letterContent, LocalDateTime letterOpenDay, String letterSendYn, String useYn, String locationX, String locationY, String locationName, String locationId, List<LetterImg> letterImgList, User user) {
        this.id = id;
        this.letterTitle = letterTitle;
        this.letterContent = letterContent;
        this.letterOpenDay = letterOpenDay;
        this.letterSendYn = letterSendYn;
        this.useYn = useYn;
        this.locationX = locationX;
        this.locationY = locationY;
        this.locationName = locationName;
        this.locationId = locationId;
    }
}
