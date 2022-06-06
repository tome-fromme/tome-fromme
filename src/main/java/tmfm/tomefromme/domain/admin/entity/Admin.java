package tmfm.tomefromme.domain.admin.entity;

import tmfm.tomefromme.domain.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "admin")
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

    //    private User user;

}
