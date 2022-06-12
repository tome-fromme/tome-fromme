package tmfm.tomefromme.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import tmfm.tomefromme.domain.base.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class NoticeImg extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalImgName;
    private String savedImgName;
    private String imgUrl;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "noticeId")
    private Notice notice;
}
