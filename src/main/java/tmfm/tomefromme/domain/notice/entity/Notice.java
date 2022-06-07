package tmfm.tomefromme.domain.notice.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tmfm.tomefromme.domain.base.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    private Object noticeImgId;

    @Column(name = "notice_title", length = 50)
    private String noticeTitle;

    @Column(name = "notice_content", length = 100)
    private String noticeContent;

    @Builder
    public Notice(Long noticeId, Object noticeImgId, String noticeTitle, String noticeContent) {
        this.noticeId = noticeId;
        this.noticeImgId = noticeImgId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
    }

}
