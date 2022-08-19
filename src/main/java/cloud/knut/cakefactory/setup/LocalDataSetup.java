package cloud.knut.cakefactory.setup;

import cloud.knut.cakefactory.domain.CakeEntity;
import cloud.knut.cakefactory.repository.CakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile({"local"})
@RequiredArgsConstructor
public class LocalDataSetup implements ApplicationRunner {

  private final CakeRepository cakeRepository;

  @Override
  public void run(final ApplicationArguments args) throws Exception {
    System.out.println();
    if (cakeRepository.count() == 0) {
      cakeRepository.save(
          CakeEntity.of("All Butter Croissant", " ", " ", BigDecimal.valueOf(0.75)));
      cakeRepository.save(CakeEntity.of("Chocolate Croissant", " ", " ", BigDecimal.valueOf(0.95)));
      cakeRepository.save(CakeEntity.of("Fresh Baguette", " ", " ", BigDecimal.valueOf(1.60)));
      cakeRepository.save(CakeEntity.of("Red Velvet", " ", " ", BigDecimal.valueOf(3.95)));
      cakeRepository.save(CakeEntity.of("Victoria Sponge", " ", " ", BigDecimal.valueOf(5.45)));
      cakeRepository.save(CakeEntity.of("Carrot Cake", " ", " ", BigDecimal.valueOf(3.45)));
    }
  }
}
