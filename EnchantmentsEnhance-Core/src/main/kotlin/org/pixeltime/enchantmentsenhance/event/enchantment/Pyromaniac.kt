/*
 *     Copyright (C) 2017-Present HealPot
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package org.pixeltime.enchantmentsenhance.event.enchantment

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.entity.EntityDamageEvent
import org.pixeltime.enchantmentsenhance.listener.EnchantmentListener
import org.pixeltime.enchantmentsenhance.manager.IM

class Pyromaniac : EnchantmentListener() {
    override fun desc(): Array<String> {
        return arrayOf("Fire ticks have a chance to heal you instead of doing damage", "你被火烧着时有几率回血而不是受到伤害")
    }

    override fun lang(): Array<String> {
        return arrayOf("火焰")
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    fun onDamage(entityDamageEvent: EntityDamageEvent) {
        if (entityDamageEvent.entity is Player) {

            val player = entityDamageEvent.entity as Player
            if (entityDamageEvent.cause == EntityDamageEvent.DamageCause.FIRE || entityDamageEvent.cause == EntityDamageEvent.DamageCause.FIRE_TICK) {
                try {
                    val level = IM.getHighestLevel(player, this.name())
                    if (level > 0 && (roll(level))) {
                        player.health = 20.0
                        player.foodLevel = 20
                    }
                } catch (ex: Exception) {
                }
            }
        }
    }
}
