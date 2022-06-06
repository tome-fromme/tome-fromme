package tmfm.tomefromme.domain.faq.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import tmfm.tomefromme.domain.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@NoArgsConstructor
public class FAQ extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String subject;

    @Column(nullable = false, length = 2000)
    private String content;

    @Column(nullable = false, length = 2)
    private String useYn;

}
