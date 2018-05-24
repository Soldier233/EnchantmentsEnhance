package org.pixeltime.enchantmentsenhance.event.enchantment

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.pixeltime.enchantmentsenhance.manager.IM
import org.pixeltime.enchantmentsenhance.manager.KM
import org.pixeltime.enchantmentsenhance.manager.SettingsManager

class Jump : Listener {
    private val translateAlternateColorCodes = ChatColor.translateAlternateColorCodes('&', SettingsManager.lang.getString("enchantment." + "jump"))
    @EventHandler
    fun onWalk(playerMoveEvent: PlayerMoveEvent) {
        val player = playerMoveEvent.player

        try {
            val armorContents = player.inventory.armorContents + IM.getAccessorySlots(player)
            for (i in armorContents.indices) {
                val itemStack = armorContents[i]
                if (itemStack.hasItemMeta() && itemStack.itemMeta.hasLore()) {
                    val level = KM.getLevel(translateAlternateColorCodes, itemStack.itemMeta.lore)
                    if (level > 0) {
                        player.addPotionEffect(PotionEffect(PotionEffectType.JUMP, 200, SettingsManager.enchant.getInt("jump.$level.potion_lvl") - 1))
                    }
                }
            }
        } catch (ex: Exception) {
        }

    }
}
