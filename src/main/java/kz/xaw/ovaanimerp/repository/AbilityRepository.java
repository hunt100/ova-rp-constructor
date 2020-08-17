package kz.xaw.ovaanimerp.repository;

import kz.xaw.ovaanimerp.data.Ability;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AbilityRepository extends BaseRepository<Ability> {
    Optional<Ability> findByName(Long abilityName);
}
