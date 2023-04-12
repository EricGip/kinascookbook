package mysqltest.mysqltest;

import org.springframework.data.repository.CrudRepository;

import mysqltest.mysqltest.Recipes;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RecipeRepository extends CrudRepository<Recipes, Integer> {
    
}