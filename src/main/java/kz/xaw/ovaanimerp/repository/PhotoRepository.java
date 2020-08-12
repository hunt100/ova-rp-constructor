package kz.xaw.ovaanimerp.repository;
import kz.xaw.ovaanimerp.data.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}

