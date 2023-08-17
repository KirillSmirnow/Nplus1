package np1.db;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@ToString
public class Participation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User sportsman;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Dog dog;

    private String heightCategory;

    public Participation(User sportsman, Dog dog, String heightCategory) {
        this.sportsman = sportsman;
        this.dog = dog;
        this.heightCategory = heightCategory;
    }
}
