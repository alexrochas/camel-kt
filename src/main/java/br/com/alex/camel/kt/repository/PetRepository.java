package br.com.alex.camel.kt.repository;

import br.com.alex.camel.kt.entity.PetEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, Integer> {

  List<PetEntity> findPetByName(String name);

}
