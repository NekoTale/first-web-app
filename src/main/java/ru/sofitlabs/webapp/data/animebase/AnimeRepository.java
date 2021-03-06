package ru.sofitlabs.webapp.data.animebase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface AnimeRepository extends JpaRepository<AnimeEntity, Long> {
    long findOneByName(String name);
}
