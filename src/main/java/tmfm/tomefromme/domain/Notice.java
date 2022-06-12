package tmfm.tomefromme.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tmfm.tomefromme.domain.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notice_title", length = 50)
    private String noticeTitle;

    @Column(name = "notice_content", length = 100)
    private String noticeContent;

    @Builder
    public Notice(Long id, String noticeTitle, String noticeContent) {
        this.id = id;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
    }

    @OneToMany(mappedBy = "notice")
    private List<NoticeImg> noticeImgList = new ArrayList<>();

}
