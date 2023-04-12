package mysqltest.mysqltest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/recipes")
public class MainController {

    @Autowired
    private RecipeRepository recipeRepository;

    @PostMapping(path="/addRecipe")
    public @ResponseBody String addNewRecipe (@RequestParam String title, @RequestParam String description) {
        Recipes n = new Recipes();
        n.setTitle(title);
        n.setDescription(description);
        recipeRepository.save(n);
        return "Saved";
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Recipes> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
