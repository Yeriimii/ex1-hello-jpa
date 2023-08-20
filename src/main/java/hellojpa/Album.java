package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") // DTYPE 값 커스터마이징 가능 (annotation 안붙이면 기본값은 엔티티 이름)
public class Album extends Item {

    private String artist;
}
