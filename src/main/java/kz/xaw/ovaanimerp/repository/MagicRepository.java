package kz.xaw.ovaanimerp.repository;

import kz.xaw.ovaanimerp.data.Magic;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MagicRepository extends BaseRepository<Magic> {
    Optional<Magic>findByName(Long magicName);
}
