package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

//    @OneToMany(mappedBy = "team") // 일대다 양방향 연결 : 읽기 전용. 업데이트는 Member 에서 해야 한다.
//    private List<Member> members = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "TEAM_ID") // 일대다 단방향 연결
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
