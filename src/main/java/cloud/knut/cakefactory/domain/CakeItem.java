package cloud.knut.cakefactory.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor(staticName = "of")
@Getter
public class CakeItem {

  @NonNull private final Long cakeId;

  @NonNull private final String name;

  @NonNull private final String type;

  @NonNull private final String description;

  @NonNull private final BigDecimal price;
}
