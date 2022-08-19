package cloud.knut.cakefactory.service;

import cloud.knut.cakefactory.domain.Cake;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@NoArgsConstructor
public class CatalogServiceImpl implements CatalogService {

  @Override
  public List<Cake> getItems() {
    return List.of(
        Cake.of(
            Long.valueOf(1),
            "Käsekuchen",
            "feine Backware",
            "Der Käsekuchen oder Quarkkuchen besteht aus Quark oder einem anderen ungesalzenen Frischkäse, Eiern, Milch und Zucker gebacken wird.",
            new BigDecimal("12.87")),
        Cake.of(
            Long.valueOf(2),
            "Donut",
            "Süßware",
            "Handtellergroßer amerikanischer/kanadischer Krapfen aus Hefeteig oder Rührteig.",
            new BigDecimal("6.98")),
        Cake.of(
            Long.valueOf(3),
            "Erdbeertorte",
            "Obsttorte",
            "Klassische Obsttorten mit Früchten und Tortenguss.",
            new BigDecimal("9.99")));
  }
}
