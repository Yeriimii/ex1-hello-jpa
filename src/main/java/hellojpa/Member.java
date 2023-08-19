package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id
    private long id;
    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) // EnumType 은 default 인 ORDINAL 을 사용하지말자
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) // DATE, TIME, TIMESTAMP 셋 중에 하나 선택 또는 Java 기본 타입 사용(LocalDate 등)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;

    @Transient // DB에 반영하지 않고 메모리에서만 사용
    private int temp;

    public Member() {
    }

}
