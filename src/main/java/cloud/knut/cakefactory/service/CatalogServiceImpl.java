package cloud.knut.cakefactory.service;

import cloud.knut.cakefactory.domain.CakeItem;
import cloud.knut.cakefactory.repository.CakeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

  CakeRepository cakeRepository;

  @Override
  public List<CakeItem> getCakes() {

    return cakeRepository.findAll(Sort.by(Sort.Order.asc("id"))).stream()
        .map(e -> CakeItem.of(e.getId(), e.getName(), e.getType(), e.getDescription(),e.getPrice()))
        .collect(Collectors.toList());
  }
}
