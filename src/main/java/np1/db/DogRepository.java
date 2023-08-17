package np1.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}
