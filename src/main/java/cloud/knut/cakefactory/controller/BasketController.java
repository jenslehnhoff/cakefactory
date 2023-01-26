package cloud.knut.cakefactory.controller;

import cloud.knut.cakefactory.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@AllArgsConstructor
@Controller
public class BasketController {

  private final CatalogService catalogService;

  @PostMapping("/basket/add/{cakeId}")
  public RedirectView addItemToBasket(@PathVariable Long cakeId){
    System.out.println("*** add item " + cakeId + " ***");
    return new RedirectView("/");
  }



}
