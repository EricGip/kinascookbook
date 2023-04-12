package mysqltest.mysqltest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Recipes {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  // my own code
  private String title;
  private String description;
  private float servings;
  private float ingredients;
  private String steps;
  private String notes;
 
  public Integer getId() {
    return id;
  }

  public void setId() {
    this.id = id; 
  }
  
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public float getServings() {
    return servings;
  }

  public void setServings(float servings) {
    this.servings = servings;
  }

  public float getIngredients() {
    return ingredients;
  }

  public void setIngredients(float ingredients) {
    this.ingredients = ingredients;
  }

  public String getSteps() {
    return steps;
  }

  public void setSteps(String steps) {
    this.steps = steps;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
  
};