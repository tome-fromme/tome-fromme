package tmfm.tomefromme.domain.letter.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import tmfm.tomefromme.domain.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private String LetterSendYn;

    @Column(nullable = false, length = 2)
    private String useYn;

    private String locationX;
    private String locationY;
    private String locationName;
    private String locationId;
}
