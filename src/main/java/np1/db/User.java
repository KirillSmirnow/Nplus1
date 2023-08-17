package np1.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user_")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public User(String name) {
        this.name = name;
    }
}
