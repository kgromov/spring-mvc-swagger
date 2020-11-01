package guru.springframework.restcontrollers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by konstantin on 01.11.2020.
 */
@RestController("recipeRestController")
@RequestMapping("recipes")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    @GetMapping("recipe/{id}")
    public RecipeCommand getRecipe(@PathVariable Long id) {
        Recipe recipe = recipeService.findById(id);
        return recipeToRecipeCommand.convert(recipe);
    }

    @PostMapping("recipe")
    public RecipeCommand saveRecipe(@RequestBody RecipeCommand recipeCommand) {
        return recipeService.saveRecipeCommand(recipeCommand);
    }

    @GetMapping("recipe")
    public Set<Recipe> getRecipes() {
        return recipeService.getRecipes();
    }
}
