package np1;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import np1.db.Participation;
import np1.db.ParticipationRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Goal: fetch all participations along with their sportsmen, dogs, and dog owners
 */
@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class Methods {

    private final ParticipationRepository participationRepository;
    private final EntityManager entityManager;

    /**
     * Default findAll. N+1 problem.
     */
    public void findAll() {
        var participations = participationRepository.findAll();
        log.info(participations.toString());
    }

    /**
     * Solving N+1 problem with JPQL join fetch.
     */
    public void jpql() {
        var participations = entityManager.createQuery(
                "from Participation p join fetch p.sportsman join fetch p.dog join fetch p.dog.owner",
                Participation.class
        ).getResultList();
        log.info(participations.toString());
    }

    /**
     * Solving N+1 problem with EntityGraph.
     */
    public void entityGraph() {
        var entityGraph = entityManager.createEntityGraph(Participation.class);
        entityGraph.addAttributeNodes("sportsman");
        entityGraph.addSubgraph("dog").addAttributeNodes("owner");

        var participations = entityManager.createQuery("from Participation", Participation.class)
                .setHint("jakarta.persistence.fetchgraph", entityGraph)
                .getResultList();
        log.info(participations.toString());
    }

    /**
     * Solving N+1 problem with Criteria API fetch.
     */
    public void criteriaApi() {
        var builder = entityManager.getCriteriaBuilder();
        var query = builder.createQuery(Participation.class);
        var root = query.from(Participation.class);
        root.fetch("sportsman");
        root.fetch("dog").fetch("owner");
        var participations = entityManager.createQuery(query).getResultList();
        log.info(participations.toString());
    }
}
