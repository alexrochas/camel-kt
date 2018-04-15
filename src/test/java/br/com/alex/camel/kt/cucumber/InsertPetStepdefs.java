package br.com.alex.camel.kt.cucumber;

import br.com.alex.camel.kt.dto.PetDto;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

public class InsertPetStepdefs implements En {

  @Autowired
  private World world;

  public InsertPetStepdefs() {
    And("^a new Pet named (.*)$", (String name) -> {
      world.map.put("pet", new PetDto(name));
    });
  }
}
