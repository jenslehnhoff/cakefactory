package cloud.knut.cakefactory.service;

import cloud.knut.cakefactory.domain.Cake;
import cloud.knut.cakefactory.domain.CakeEntity;
import cloud.knut.cakefactory.repository.CakeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

  CakeRepository cakeRepository;

  @Override
  public List<Cake> getCakes() {

    return cakeRepository.findAll(Sort.by(Sort.Order.asc("id"))).stream()
        .map(e -> Cake.of(e.getName(), e.getType(), e.getDescription(),e.getPrice()))
        .collect(Collectors.toList());
  }
}
