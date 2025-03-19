package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "pizzas")
public class Pizza {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "The name cannot be empty")
  private String name;

  @Lob
  private String description;

  @Lob
  private String image;

  @NotBlank
  @Min(value = 0, message = "The price must be positive")
  private Integer price;

  // constructor
  public Pizza(Integer id, String name, String description, String image, Integer price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.image = image;
    this.price = price;
  }

  public Pizza() {

  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return this.image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Integer getPrice() {
    return this.price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String toString() {
    return "Nome: " + name;
  }
}
