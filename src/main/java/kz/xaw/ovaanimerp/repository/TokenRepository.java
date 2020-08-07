package kz.xaw.ovaanimerp.repository;

import kz.xaw.ovaanimerp.data.Token;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends BaseRepository<Token> {

    Optional<Token> findByToken(String token);
}
