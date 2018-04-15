package br.com.alex.camel.kt.cucumber;

import static org.junit.Assert.assertEquals;

import br.com.alex.camel.kt.dto.PetDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class InsertPetStepdefs implements En {

  @Autowired
  private World world;

  public InsertPetStepdefs() {
    And("^a new Pet named (.*)$", (String name) -> {
      world.map.put("request", new PetDto(name));
    });

    And("^return inserted Pet with name (.*)$", (name) -> {
      ObjectMapper objectMapper = new ObjectMapper();
      assertEquals(objectMapper.convertValue(((ResponseEntity<PetDto>) world.map.get("response")).getBody(),
              PetDto.class).getName(), name);
    });
  }
}
