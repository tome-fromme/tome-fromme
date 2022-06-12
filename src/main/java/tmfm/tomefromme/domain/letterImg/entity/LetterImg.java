package tmfm.tomefromme.domain.letterImg.entity;

import tmfm.tomefromme.domain.base.BaseEntity;
import tmfm.tomefromme.domain.letter.entity.Letter;

import javax.persistence.*;

@Entity
public class LetterImg extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterImgId;

    @Column(nullable = false, length = 50)
    private String originalImgName;

    @Column(nullable = false, length = 50)
    private String savedImgName;

    @Column(nullable = false)
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Letter letter;

}
