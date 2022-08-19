package cloud.knut.cakefactory.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Getter
@Table(name = "cake")
public class CakeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @NonNull
  @Column(name = "name", nullable = false)
  private String name;

  @NonNull
  @Column(name = "type", nullable = false)
  private String type;

  @NonNull
  @Column(name = "description", nullable = false)
  private String description;

  @NonNull
  @Column(name ="price", nullable = false)
  private BigDecimal price;

}
