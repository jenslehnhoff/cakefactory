package cloud.knut.cakefactory.controller;

import cloud.knut.cakefactory.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@AllArgsConstructor
@Controller
public class CatalogController {

  private final CatalogService catalogService;

  @GetMapping("/")
  ModelAndView index() {
    return new ModelAndView("catalog", Map.of("items", catalogService.getCakes()));
  }

}
