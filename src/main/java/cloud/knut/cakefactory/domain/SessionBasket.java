package cloud.knut.cakefactory.domain;

import cloud.knut.cakefactory.repository.CakeRepository;
import cloud.knut.cakefactory.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
@RequiredArgsConstructor
public class SessionBasket {

    private final CatalogService catalogService;

    private final Map<Long, CakeItem> items = new ConcurrentHashMap<>();

    public void add(Long cakeId) {

        CakeItem cakeItem = catalogService.get // service braucht neue getByCakeId methode

        items.compute(cakeId, (existingCakeId, existingCakeItem) -> {

           if (existingCakeItem == null){
               return new BasketItem()
           }


        });


    }
}
