package cloud.knut.cakefactory.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Getter
public class CakeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NonNull
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

  public CakeEntity(final String type) {
    this.type = type;
  }
}
