package guru.springframework.controller;

import guru.springframework.domain.Category;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class IndexController {

    CategoryRepository categoryRepository;
    UnitOfMeasureRepository unitOfMeasureRepository;
    RecipeRepository recipeRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUom("Teaspoon");



        System.out.println("Category ID: " + categoryOptional.get().getId());
        System.out.println("Unit od measure ID: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
