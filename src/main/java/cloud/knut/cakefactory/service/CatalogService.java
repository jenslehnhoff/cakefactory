package cloud.knut.cakefactory.service;

import cloud.knut.cakefactory.domain.CakeItem;

import java.util.List;

public interface CatalogService {

  List<CakeItem> getCakes();
}
