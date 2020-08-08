package kz.xaw.ovaanimerp.repository;

import kz.xaw.ovaanimerp.repository.BaseRepository;
import kz.xaw.ovaanimerp.security.AppUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends BaseRepository<AppUser> {
    Optional<AppUser> findByLogin(String login);
}
