package tmfm.tomefromme.domain.letterImg.entity;

import tmfm.tomefromme.domain.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "letter_img")
public class LetterImg extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterImgId;

    @Column(nullable = false, length = 50)
    private String originalImgName;

    @Column(nullable = false, length = 50)
    private String savedImgName;

    private String imgUrl;

//    private Letter letter;

}
