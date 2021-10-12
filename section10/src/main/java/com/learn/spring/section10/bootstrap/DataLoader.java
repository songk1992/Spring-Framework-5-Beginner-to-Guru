package com.learn.spring.section10.bootstrap;

import com.learn.spring.section10.domain.*;
import com.learn.spring.section10.service.CategoryService;
import com.learn.spring.section10.service.RecipeService;
import com.learn.spring.section10.service.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryService categoryService;
    private final RecipeService recipeService;
    private final UnitOfMeasureService unitOfMeasureService;

    public DataLoader(CategoryService categoryService, RecipeService recipeService, UnitOfMeasureService unitOfMeasureService) {
        this.categoryService = categoryService;
        this.recipeService = recipeService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @Override
    @Transactional
    public void run(String... args) {
        recipeService.saveAll(getRecipes());
        log.debug("Loading Bootstrap Data");
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>();

        /* 단위 uom */


        UnitOfMeasure eachUom = unitOfMeasureService.findByDescription("Each");

        /* 카테고리 category */
        Category koreanCategory = categoryService.findByDescription("Korean");


        /* 김치 Recipe */
        Recipe kimchiRecipe = new Recipe();
        kimchiRecipe.setDescription("Kimchi");
        kimchiRecipe.setPrepTime(10);
        kimchiRecipe.setCookTime(10);
        kimchiRecipe.setSource("wiki books");
        kimchiRecipe.setUrl("https://ko.wikibooks.org/wiki/%EA%B9%80%EC%B9%98");
        kimchiRecipe.setServings(4);
        kimchiRecipe.setDifficulty(Difficulty.EASY);
        kimchiRecipe.setDirections(
                "               싱싱한 배추를 골라 누런 겉잎은 떼고 큰 통은 사등분을 하고 작은 것은 반으로 가른다.\n" +
         "                        굵은 소금을 조금 남기고 물에 풀어 쪼갠 배추를 소금물에 담갔다 건져서, 배추 줄기 쪽에 소금을 약간씩 뿌려서 가른 단면이 위로 오게 큰 독이나 큰 용기에 차곡차곡 담아 절인다. 다섯 시간쯤 후에 위아래를 바꾸어 전체가 고루 절게 한다.\n" +
         "                        절인 배추는 냉수로 물을 바꾸어 가며 깨끗이 헹구어 건져 소쿠리에 엎어서 물기를 뺀다. 포기가 큰 것은 다시 반으로 가르고 굵은 뿌리 부분을 말끔하게 도려낸다.\n" +
         "                        무는 몸이 단단하고 매끄러운 것으로 골라 잔뿌리는 떼고 깨끗이 씻어서 물기를 빼고 2mm 폭으로 둥글게 썬 다음 채 썬다.\n" +
         "                        쪽파, 갓, 미나리는 다듬어 씻어 4cm 길이로 썰고 대파는 흰 부분만 어슷어슷하게 썬다.\n" +
         "                        생강, 마늘은 껍질을 벗겨 씻어 물기를 빼서 절구에 다지고 새우젓은 건더기만 건져 굵게 다지고 젓국은 남긴다.\n" +
         "                        생굴은 껍질을 골라내고 슴슴한 소금물에 헹궈 씻어 건진다.\n" +
         "                        생새우는 티를 골라내고 씻어 물기를 뺀 후 분마기에 곱게 간다.\n" +
         "                        고춧가루를 따뜻한 물에 불린 후 새우젓국, 멸치젓국을 넣어 더 불게 둔다."
        );

        Notes kimchiNote = new Notes();
        kimchiNote.setRecipeNotes(
                "배추 10포기(30kg)\n" +
                        "굵은 소금 19컵(3kg)\n" +
                        "무 3개(4.5kg)\n" +
                        "쪽파 1단(400g)\n" +
                        "갓 1단 (1kg)\n" +
                        "미나리 2단(600g)\n" +
                        "대파 반 단(400g)\n" +
                        "마늘 10통(400g)\n" +
                        "생강 3톨(100g)\n" +
                        "고춧가루 10컵(800g)\n" +
                        "따뜻한 물 2컵\n" +
                        "새우젓 1컵(250g)\n" +
                        "멸치젓 1컵( 200g)\n" +
                        "생굴 1컵(200g)\n" +
                        "생새우 2컵(300g)\n" +
                        "소금\n" +
                        "설탕\n" +
                        "출처 https://ko.wikibooks.org/wiki/%EA%B9%80%EC%B9%98"
        );

        kimchiNote.setRecipe(kimchiRecipe);
        kimchiRecipe.setNotes(kimchiNote);

        kimchiRecipe.getCategories().add(koreanCategory);

        kimchiRecipe.getIngredient().add(new Ingredient("배추", new BigDecimal(1), eachUom));

        kimchiRecipe.getCategories().add(koreanCategory);

        recipes.add(kimchiRecipe);



        return recipes;
    }


}
