package org.pixeltime.enchantmentsenhance.gui.menu.buttons;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.pixeltime.enchantmentsenhance.interfaces.Clickable;
import org.pixeltime.enchantmentsenhance.manager.SettingsManager;
import org.pixeltime.enchantmentsenhance.util.ItemBuilder;
import org.pixeltime.enchantmentsenhance.util.Util;

public class EnhanceButton extends Clickable {
    @Override
    public ItemStack getItem() {
        return new ItemBuilder(Material.WOOL).setDyeColor(DyeColor.YELLOW).setName(SettingsManager.lang.getString("Menu.gui.enhance")).addLoreLine(SettingsManager.lang.getString(
                "Menu.lore.ifSuccess")).addLoreLine(SettingsManager.lang.getString(
                "Menu.lore.ifFail")).addLoreLine(SettingsManager.lang.getString(
                "Menu.lore.ifDowngrade")).addLoreLine(SettingsManager.lang.getString(
                "Menu.lore.ifDestroy")).toItemStack();
    }

    @Override
    public int getPosition() {
        return Util.getSlot(4, 5);
    }
}
