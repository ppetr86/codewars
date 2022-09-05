package com.example.codewars3.playground.cookbook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

public class Cookbook {
    private static final Map<String, Recipe> cbook = new HashMap<>();

    public static void main(String[] args) {
        Recipe.addRecipes(cbook); // from Listing 9-15
        System.out.println("\n---VEGAN RECIPES---");
        printRecipes(r -> r.isVegan());
        System.out.println("\n---RECIPES USING 4+ ITEMS---");
        printRecipes(r -> foodsUsed1(r) >= 4);
        printRecipes(r -> foodsUsed2(r) >= 4);
        printRecipes(r -> foodsUsed3(r) >= 4);
        System.out.println("\n---RECIPES COMPRISING SALAD---");
        printRecipesUsedIn1(cbook.get("salad"));
        printRecipesUsedIn2(cbook.get("salad"));
        System.out.println("\n---SHOPPING LIST FOR SALAD---");
        printShoppingList(cbook.get("salad"), 1);
    }

    protected static void printRecipesUsedIn1(Recipe r) {
        for (FoodItem item : r) {
            if (item instanceof Recipe)
                System.out.println(item.name());
        }
    }

    protected static void printRecipesUsedIn2(Recipe r) {
        r.forEach(item -> {
            if (item instanceof Recipe) {
                System.out.println(item.name());
            }
        });
    }

    private static int foodsUsed1(FoodItem r) {
        int count = 0;
        if (r instanceof BasicFood)
            count = 1;
        else {
            Iterator<FoodItem> iter = r.childIterator();
            while (iter.hasNext())
                count += foodsUsed1(iter.next());
        }
        return count;
    }

    private static int foodsUsed2(FoodItem r) {
        int count = 0;
        Iterator<FoodItem> iter = r.iterator();
        while (iter.hasNext())
            if (iter.next() instanceof BasicFood)
                count++;
        return count;
    }

    private static int foodsUsed3(FoodItem r) {
        int count = 0;
        for (FoodItem item : r)
            if (item instanceof BasicFood)
                count++;
        return count;
    }

    private static void printRecipes(Predicate<Recipe> pred) {
        for (Recipe r : cbook.values())
            if (pred.test(r))
                System.out.println(r);
    }

    private static void printShoppingList(Recipe r, int howmany) {
        Iterator<FoodItem> iter = r.childIterator();
        while (iter.hasNext()) {
            FoodItem item = iter.next();
            int amt = r.getQuantity(item) * howmany;
            if (item instanceof BasicFood)
                System.out.println(item.name() + " " + amt);
            else
                printShoppingList((Recipe) item, amt);
        }
    }
}
