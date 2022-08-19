package cloud.knut.cakefactory.repository;

import cloud.knut.cakefactory.domain.CakeEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CakeRepositoryIT {

  @Autowired TestEntityManager entityManager;

  @Autowired CakeRepository cakeRepository;

  @Test
  @DisplayName("Persist a CakeEntity and findAll")
  void findAllWithPersistedCakeEntity() {

    // given
    final String name = "Donut";
    final String type = "Krapfen";
    final String description =
        "Ein Donut ist ein handtellergroßer amerikanischer/kanadischer Krapfen aus Hefeteig oder Rührteig.";
    final BigDecimal price = BigDecimal.valueOf(1.99);

    cakeRepository.save(CakeEntity.of(name, type, description, price));

    // when
    final List<CakeEntity> cakeEntities = cakeRepository.findAll();

    // then
    assertEquals(1, cakeEntities.size());
    assertEquals(name, cakeEntities.get(0).getName());
    assertEquals(type, cakeEntities.get(0).getType());
    assertEquals(description, cakeEntities.get(0).getDescription());
  }
}
