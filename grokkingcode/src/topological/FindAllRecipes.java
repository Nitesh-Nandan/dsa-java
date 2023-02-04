package topological;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class FindAllRecipes {

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> recipesIndegree = new HashMap<>();
        Map<String, List<String>> ingredientToRecipeMap = new HashMap<>();

        HashSet<String> suppliesSet = (HashSet<String>) Arrays.stream(supplies).collect(Collectors.toSet());
        for (String recipe : recipes) {
            recipesIndegree.put(recipe, 0);
        }

        for (int i = 0; i < recipes.length; i++) {
            String currRecipe = recipes[i];
            List<String> ingredientList = ingredients.get(i);
            for (String ing : ingredientList) {
                if (!suppliesSet.contains(ing)) {
                    List<String> existingRecipe = ingredientToRecipeMap.getOrDefault(ing, new ArrayList<>());
                    existingRecipe.add(currRecipe);
                    ingredientToRecipeMap.put(ing, existingRecipe);
                    recipesIndegree.put(currRecipe, recipesIndegree.getOrDefault(currRecipe, 0) + 1);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();

        for (Map.Entry<String, Integer> entry : recipesIndegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            String recipe = queue.poll();
            ans.add(recipe);
            for (String nbr : ingredientToRecipeMap.getOrDefault(recipe, new ArrayList<>())) {
                recipesIndegree.put(nbr, recipesIndegree.get(nbr) - 1);
                if (recipesIndegree.get(nbr) == 0) {
                    queue.offer(nbr);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        String[] recipes = new String[]{"bread", "sandwich", "burger"};
        List<List<String>> ingredients = Arrays.asList(
                Arrays.asList("yeast", "flour"),
                Arrays.asList("bread", "meat"),
                Arrays.asList("sandwich", "meat", "bread")
        );
        String[] supplies = new String[]{"yeast", "flour", "meat"};

        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }
}
