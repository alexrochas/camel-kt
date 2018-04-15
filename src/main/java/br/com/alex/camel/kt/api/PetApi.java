package br.com.alex.camel.kt.api;

import br.com.alex.camel.kt.dto.PetDto;
import br.com.alex.camel.kt.entity.PetEntity;
import br.com.alex.camel.kt.repository.PetRepository;
import java.util.Map;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetApi {

  @Autowired
  private PetRepository petRepository;

  @GetMapping("/pets")
  public ResponseEntity<?> fetchPets(@RequestParam Map<String, String> queryParams) {
    String name = queryParams.get("name");
    if (name != null && !name.isEmpty()) {
      for (PetEntity petEntity : petRepository.findAll()) {
        if (petEntity.getName().equals(name)) {
          return ResponseEntity.ok(Lists.newArrayList(convertEntityToDto(petEntity)));
        }
      }
    }
    return ResponseEntity.status(200).body(petRepository.findAll());
  }

  @PostMapping
  public ResponseEntity<?> addPet(@RequestBody PetDto pet) {
    return ResponseEntity.ok(convertEntityToDto(
            petRepository.save(convertDtoToEntity(pet))));
  }

  private PetDto convertEntityToDto(PetEntity pet) {
    return new PetDto(pet.getName());
  }

  private PetEntity convertDtoToEntity(PetDto pet) {
    return new PetEntity(pet.getName());
  }

}
