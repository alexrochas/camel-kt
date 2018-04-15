package br.com.alex.camel.kt.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import br.com.alex.camel.kt.dto.PetDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java8.En;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class InsertPetStepdefs implements En {

  @Autowired
  private World world;

  public InsertPetStepdefs() {
    And("^a new Pet named (.*)$", (String name) -> {
      world.map.put("request", new PetDto(name));
    });

    And("^return Pet with name (.*)$", (String name) -> {
      ObjectMapper objectMapper = new ObjectMapper();
      ResponseEntity<PetDto> response = ((ResponseEntity<PetDto>) world.map.get("response"));
      if (response.getBody() instanceof List) {
        List<PetDto> pets = objectMapper.convertValue(response.getBody(),
                new TypeReference<List<PetDto>>() {
                });
        assertTrue(pets.stream().anyMatch(p -> p.getName().equals(name)));
      } else {
        assertEquals(objectMapper.convertValue(response.getBody(), PetDto.class).getName(), name);
      }
    });
  }
}
