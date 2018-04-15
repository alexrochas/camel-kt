package br.com.alex.camel.kt.cucumber;

import static org.junit.Assert.assertTrue;

import br.com.alex.camel.kt.dto.PetDto;
import cucumber.api.java8.En;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class InsertPetStepdefs implements En {

  @Autowired
  private World world;

  public InsertPetStepdefs() {
    And("^a new Pet named (.*)$", (String name) -> {
      world.map.put("pet", new PetDto(name));
    });

    And("^return inserted Pet with name (.*)$", (name) -> {
      assertTrue(((ResponseEntity<List<PetDto>>)world.map.get("response")).getBody()
              .stream()
              .filter((p) -> p.getName().equals(name))
              .findAny()
              .isPresent()
      );
    });
  }
}
