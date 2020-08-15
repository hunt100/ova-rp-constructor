package kz.xaw.ovaanimerp.repository;

import kz.xaw.ovaanimerp.data.DocumentTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentTemplateRepository extends BaseRepository<DocumentTemplate> {

    Optional<DocumentTemplate> findByDocKey(String key);
}
