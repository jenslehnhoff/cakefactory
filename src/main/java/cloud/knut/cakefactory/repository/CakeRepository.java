package cloud.knut.cakefactory.repository;

import cloud.knut.cakefactory.domain.CakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends JpaRepository<CakeEntity, Long> {

}
