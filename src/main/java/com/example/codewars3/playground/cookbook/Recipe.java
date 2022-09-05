package com.example.codewars3.playground.cookbook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Recipe implements FoodItem {
    private final String name;
    private final Map<FoodItem, Integer> ingredients = new HashMap<>();
    private final String directions;

    public Recipe(String name, String directions) {
        this.name = name;
        this.directions = directions;
    }

    public void addIngredient(FoodItem item, int qty) {
        ingredients.put(item, qty);
    }

    public Iterator<FoodItem> childIterator() {
        return ingredients.keySet().iterator();
    }

    public int getQuantity(FoodItem item) {
        return ingredients.get(item);
    }

    public boolean isVegan() {
        Iterator<FoodItem> iter = childIterator();
        while (iter.hasNext())
            if (!iter.next().isVegan())
                return false;
        return true;
    }

    public String name() {
        return name;
    }

    public String toString() {
        String veg = isVegan() ? " (vegan)" : "";
        String result = "Recipe for " + name + veg + "\n";
        result += "Ingredients:";
        for (FoodItem item : ingredients.keySet()) {
            int qty = ingredients.get(item);
            result += "\t" + qty + " " + item.name() + "\n";
        }
        return result + "Directions: " + directions + "\n";
    }

    protected static void addRecipes(Map<String, Recipe> cbook) {
        Recipe dressing = new Recipe("dressing", "Mix well.");
        dressing.addIngredient(new BasicFood("oil", true), 4);
        dressing.addIngredient(new BasicFood("vinegar", true), 2);
        cbook.put("dressing", dressing);
        Recipe salad = new Recipe("salad", "Chop lettuce, add bacon. Pour dressing over it.");
        salad.addIngredient(new BasicFood("lettuce", true), 1);
        salad.addIngredient(new BasicFood("bacon", false), 6);
        salad.addIngredient(dressing, 1);
        cbook.put("salad", salad);
    }
}
