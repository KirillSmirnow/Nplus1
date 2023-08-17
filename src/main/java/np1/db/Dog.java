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
public class Dog {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User owner;

    private String name;

    public Dog(User owner, String name) {
        this.owner = owner;
        this.name = name;
    }
}
