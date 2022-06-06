package tmfm.tomefromme.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tmfm.tomefromme.domain.base.BaseEntity;
import tmfm.tomefromme.domain.role.entity.Role;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private Object roleId;

    @Column(name = "social_id", length = 20)
    private String socialId;

    @Column(name = "social_type")
    private char socialType;

    @Column(nullable = false, name = "user_name", length = 50)
    private String userEmail;

    @Column(nullable = false, name = "user_yn")
    private char userYn;

    @PrePersist
    public void prePersist() {
        this.socialType = this.socialType == 0 ? 'N' : this.socialType;
        this.userYn = this.userYn == 0 ? 'N' : this.socialType;
    }

    @Builder
    public User(Long userId, Role roleId, String socialId, char socialType, String userEmail, char userYn) {
        this.userId = userId;
        this.roleId = roleId;
        this.socialId = socialId;
        this.socialType = socialType;
        this.userEmail = userEmail;
        this.userYn = userYn;
    }

}
