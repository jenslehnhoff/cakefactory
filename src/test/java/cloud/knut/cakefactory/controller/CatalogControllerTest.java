package cloud.knut.cakefactory.controller;

import cloud.knut.cakefactory.controller.CatalogController;
import cloud.knut.cakefactory.domain.Cake;
import cloud.knut.cakefactory.service.CatalogService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CatalogController.class)
class CatalogControllerTest {

  private WebClient webClient;

  @Autowired private MockMvc mockMvc;

  @MockBean private CatalogService catalogService;

  @BeforeEach
  void init() throws Exception {
    this.webClient = MockMvcWebClientBuilder.mockMvcSetup(mockMvc).build();
  }

  @AfterEach
  void close() throws Exception {}

  @Test
  void shouldHaveTitel_whenLoadPage() throws Exception {

    mockMvc
        .perform(MockMvcRequestBuilders.get("/"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Cake Factory")));
  }

  @Test
  void shouldHaveCake_whenLoadPage_withHtmlPageAndWebClient() throws Exception {

    // given
    final String expectedTitle = "Erdbeertorte";
    when(catalogService.getCakes())
        .thenReturn(
            Collections.singletonList(
                Cake.of(
                    "Erdbeertorte",
                    "Obsttorte",
                    "Klassische Obsttorten mit Früchten und Tortenguss.",
                    new BigDecimal("12.87"))));

    final HtmlPage page = webClient.getPage("http://localhost");

    assertThat(page.getTitleText()).isEqualTo("Cake Factory - Start Bootstrap Template");

    assertThat(page.querySelectorAll(".card-title"))
        .anyMatch(domElement -> expectedTitle.equals(domElement.getVisibleText()));
  }

  @Test
  void shouldHaveCake_whenLoadPage_withMvcMockResponse() throws Exception {

    // given

    // when
    final MockHttpServletResponse response =
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andReturn().getResponse();

    // then
    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
  }


  @Test
  @DisplayName("index page returns the landing page")
  void returnsLandingPage() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Cake Factory")));
  }

}
