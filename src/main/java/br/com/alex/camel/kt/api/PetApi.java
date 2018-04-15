package br.com.alex.camel.kt.api;

import br.com.alex.camel.kt.dto.PetDto;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetApi {

  @GetMapping("/pets")
  public ResponseEntity<?> fetchPets() {
    PetDto petDto = new PetDto();
    petDto.setId(1);
    petDto.setName("Jupiter");

    ArrayList<Object> pets = new ArrayList<>();
    pets.add(petDto);

    return ResponseEntity.status(200).body(pets);
  }

}
