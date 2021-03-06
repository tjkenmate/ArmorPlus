/*******************************************************************************
 * Copyright (c) TheDragonTeam 2016.
 ******************************************************************************/

package net.thedragonteam.armorplus.armors.v2.electrical;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.thedragonteam.armorplus.ARPConfig;
import net.thedragonteam.armorplus.armors.base.BaseArmor;
import net.thedragonteam.armorplus.registry.ModBlocks;
import net.thedragonteam.armorplus.registry.ModItems;

/**
 * net.thedragonteam.armorplus.armors.v2.electrical
 * ArmorPlus created by sokratis12GR on 7/28/2016 9:19 AM.
 * - TheDragonTeam
 */
public class ElectricalHelmet extends BaseArmor {

    public ElectricalHelmet() {
        super(ModItems.electricalArmor, 0, EntityEquipmentSlot.HEAD, "electrical_helmet");
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        if (ARPConfig.recipes == 0) {
            return repair.getItem() == ModItems.electricalIngot;
        }
        if (ARPConfig.recipes == 1) {
            return repair.getItem() == Item.getItemFromBlock(ModBlocks.electricalBlock);
        }
        return true;
    }
}