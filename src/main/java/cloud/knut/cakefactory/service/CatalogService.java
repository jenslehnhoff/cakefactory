package cloud.knut.cakefactory.service;

import cloud.knut.cakefactory.domain.Cake;

import java.util.List;

public interface CatalogService {

  List<Cake> getItems();
}
