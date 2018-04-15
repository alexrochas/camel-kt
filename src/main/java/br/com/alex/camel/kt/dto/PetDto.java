package br.com.alex.camel.kt.dto;

public class PetDto {

  private Integer id;
  private String name;

  public PetDto() {
  }

  public PetDto(String name) {
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
