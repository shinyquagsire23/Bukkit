package org.bukkit.potion;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.BrewRecipe;
import org.bukkit.potion.PotionEffect;

public class PotionRecipes {
    private PotionRecipes() {
    }

    private static HashMap<Integer, String> recipes = new HashMap<Integer, String>();
    private static ArrayList<Integer> newIngredients = new ArrayList<Integer>();
    private static HashMap<Integer, ArrayList<PotionEffect>> newEffects = new HashMap<Integer, ArrayList<PotionEffect>>();

    public static void addRecipe(String bitModifier, Material material) {
        recipes.put(material.getId(), bitModifier);
        if (!newIngredients.contains(material.getId()))
            newIngredients.add(material.getId());
    }

    public static void overrideEffect(BrewRecipe recipe, PotionEffect neweffect) {
        overrideEffect(recipe.getResult().getDurability(), neweffect);
    }

    public static void overrideEffect(int potiondata, PotionEffect neweffect) {
        ArrayList<PotionEffect> effect = new ArrayList<PotionEffect>();
        effect.add(neweffect);

        int data = potiondata;
        if (data > 15)
            data = (data << 12) >> 12;

        overrideEffect(data, effect);
    }

    public static void overrideEffect(int potiondata, ArrayList<PotionEffect> neweffects) {
        newEffects.put(potiondata, neweffects);
    }

    public static String getBitsforMaterial(Material material) {
        return recipes.get(material);
    }

    public static String getBitsforId(int material) {
        return recipes.get(material);
    }

    public static ArrayList<Integer> getNewIngredients() {
        return newIngredients;
    }

    public static HashMap<Integer, ArrayList<PotionEffect>> getNewEffectsTable() {
        return newEffects;
    }

    public static HashMap<Integer, String> getRecipes() {
        return recipes;
    }
}