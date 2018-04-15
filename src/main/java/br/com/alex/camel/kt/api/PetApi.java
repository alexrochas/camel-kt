package br.com.alex.camel.kt.api;

import br.com.alex.camel.kt.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetApi {

  @Autowired
  private PetRepository petRepository;

  @GetMapping("/pets")
  public ResponseEntity<?> fetchPets() {
    return ResponseEntity.status(200).body(petRepository.findAll());
  }

  @PostMapping
  public ResponseEntity<?> addPet() {
    return ResponseEntity.ok(200);
  }

}
