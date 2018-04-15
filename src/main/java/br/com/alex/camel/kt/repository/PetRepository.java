package br.com.alex.camel.kt.repository;

import br.com.alex.camel.kt.entity.PetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, Integer> {

}
