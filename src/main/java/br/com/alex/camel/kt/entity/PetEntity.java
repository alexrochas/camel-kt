package br.com.alex.camel.kt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Pets")
public class PetEntity {

  @Id
  @GeneratedValue
  private Integer id;
  private String name;

  public PetEntity() {
  }

  public PetEntity(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
