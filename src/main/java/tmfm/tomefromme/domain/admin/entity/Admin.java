package tmfm.tomefromme.domain.admin.entity;

import tmfm.tomefromme.domain.base.BaseEntity;
import tmfm.tomefromme.domain.user.entity.User;

import javax.persistence.*;

@Entity
public class Admin extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @Column(length = 20)
    private String adminName;

    @Column(length = 50)
    private String adminDept;

    @Column(length = 30)
    private String adminLevel;

    @Column(length = 20)
    private String adminPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private User user;

}
