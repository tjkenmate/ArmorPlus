/*******************************************************************************
 * Copyright (c) TheDragonTeam 2016.
 ******************************************************************************/

package net.thedragonteam.armorplus.armors.special.superstar;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.thedragonteam.armorplus.ARPConfig;
import net.thedragonteam.armorplus.armors.base.BaseArmor;
import net.thedragonteam.armorplus.registry.ModItems;

import java.util.List;

import static net.thedragonteam.core.util.TextHelper.localize;

/**
 * net.thedragonteam.armorplus.armors.special.superstar
 * ArmorPlus created by sokratis12GR on 7/25/2016 10:08 AM.
 * - TheDragonTeam
 */
public class SuperStarChestplate extends BaseArmor {

    public SuperStarChestplate() {
        super(ModItems.superStarArmor, 0, EntityEquipmentSlot.CHEST, "super_star_chestplate");
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        int superstarArmorEffectlevel = ARPConfig.superstarArmorEffectlevel + 1;
        if (ARPConfig.enableSuperStarCRegen) {
            tooltip.add("\2479Ability: " + "\247rRegeneration " + superstarArmorEffectlevel);
            tooltip.add("\2473Use: " + "\247rEquip A Piece");
        }
        if (ARPConfig.enableFullSuperStarArmorEffect) {
            tooltip.add("\2479Ability: " + "\247rRegeneration " + superstarArmorEffectlevel);
            tooltip.add("\2473Use: " + "\247rEquip The Full Set");
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
        if (ARPConfig.enableSuperStarCRegen && entity instanceof EntityLivingBase && !ARPConfig.enableFullSuperStarArmorEffect) {
            entity.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 120, ARPConfig.superstarArmorEffectlevel, true, true));
            entity.removePotionEffect(MobEffects.WITHER);
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return (TextFormatting.WHITE + localize(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == ModItems.witherBone;
    }
}