package kz.xaw.ovaanimerp.repository;

import kz.xaw.ovaanimerp.security.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Role> {

    Optional<Role> findByName(String name);
}
