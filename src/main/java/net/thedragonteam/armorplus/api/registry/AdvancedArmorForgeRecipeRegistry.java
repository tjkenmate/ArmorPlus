/*******************************************************************************
 * Copyright (c) TheDragonTeam 2016.
 ******************************************************************************/

package net.thedragonteam.armorplus.api.registry;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thedragonteam.armorplus.api.recipe.AdvancedArmorForgeRecipe;

import java.util.ArrayList;
import java.util.List;

/**
 * net.thedragonteam.armorplus.api.registry
 * ArmorPlus created by sokratis12GR on 6/21/2016 11:47 PM.
 * - TheDragonTeam
 */
public class AdvancedArmorForgeRecipeRegistry {
    private static List<AdvancedArmorForgeRecipe> recipeList = new ArrayList<AdvancedArmorForgeRecipe>();

    public static void registerRecipe(AdvancedArmorForgeRecipe recipe) {
        recipeList.add(recipe);
    }

    public static void registerRecipe(ItemStack outputStack, Object... objects) {
        registerRecipe(new AdvancedArmorForgeRecipe(outputStack, objects));
    }

    public static AdvancedArmorForgeRecipe getMatchingRecipe(List<ItemStack> itemList, World world, BlockPos pos) {
        for (AdvancedArmorForgeRecipe recipe : recipeList) {
            if (recipe.matches(itemList, world, pos)) {
                return recipe;
            }
        }

        return null;
    }

    public static List<AdvancedArmorForgeRecipe> getRecipeList() {
        return new ArrayList<AdvancedArmorForgeRecipe>(recipeList);
    }
}