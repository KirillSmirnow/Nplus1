package np1;

import lombok.RequiredArgsConstructor;
import np1.db.*;
import org.springframework.stereotype.Component;

import static java.util.stream.IntStream.range;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final DogRepository dogRepository;
    private final ParticipationRepository participationRepository;

    public void initialize() {
        range(0, 10).forEach($ -> {
            var owner = userRepository.save(new User(randomAlphabetic(8)));
            var dog = dogRepository.save(new Dog(owner, randomAlphabetic(8)));
            var sportsman = userRepository.save(new User(randomAlphabetic(8)));
            participationRepository.save(new Participation(sportsman, dog, randomAlphabetic(8)));
        });
    }
}
