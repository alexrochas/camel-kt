package br.com.alex.camel.kt.cucumber;

import static org.junit.Assert.assertEquals;

import br.com.alex.camel.kt.TestConfig;
import br.com.alex.camel.kt.dto.PetDto;
import cucumber.api.java8.En;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SearchPetStepdefs extends TestConfig implements En {

  @Autowired
  public World world;
  @LocalServerPort
  public Integer port;

  public SearchPetStepdefs() {
    Given("^a running API$", () -> {

    });

    When("^hitting (.*) to (.*)$", (endpoint, verb) -> {
      RestTemplate restTemplate = new RestTemplateBuilder().build();

      ParameterizedTypeReference<List<PetDto>> typeReference = new ParameterizedTypeReference<List<PetDto>>(){};
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      headers.setContentType(MediaType.APPLICATION_JSON);
      HttpEntity<List<PetDto>> entity = new HttpEntity<>(headers);
      ResponseEntity<List<PetDto>> response = restTemplate
              .exchange("http://localhost:" + port + endpoint, ((Map<String, HttpMethod>) world.map.get("verbs")).get(verb), entity, typeReference);
      world.map.put("response", response);
    });

    Then("^return status (\\d+)$", (Integer status) -> {
      assertEquals(HttpStatus.valueOf(status), ((ResponseEntity<List<PetDto>>) world.map.get("response")).getStatusCode());
    });
  }
}
