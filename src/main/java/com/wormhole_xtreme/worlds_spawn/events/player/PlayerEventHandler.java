/*
 * Wormhole X-Treme Worlds Spawn Plugin for Bukkit
 * Copyright (C) 2011 Dean Bailey
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.wormhole_xtreme.worlds_spawn.events.player;

import java.util.logging.Level;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.wormhole_xtreme.worlds_spawn.WormholeXTremeWorldsSpawn;

/**
 * The Class PlayerEventHandler.
 * 
 * @author alron
 */
public class PlayerEventHandler extends PlayerListener {

    /** The Constant thisPlugin. */
    private static final WormholeXTremeWorldsSpawn thisPlugin = WormholeXTremeWorldsSpawn.getThisPlugin();

    /* (non-Javadoc)
     * @see org.bukkit.event.player.PlayerListener#onPlayerRespawn(org.bukkit.event.player.PlayerRespawnEvent)
     */
    @Override
    public void onPlayerRespawn(final PlayerRespawnEvent event) {
        final Player player = event.getPlayer();
        final Location respawnLocation = WormholeXTremeWorldsSpawn.getWorldHandler().getPlayerRespawnLocation(player);
        if (respawnLocation != null) {
            event.setRespawnLocation(respawnLocation);
            thisPlugin.prettyLog(Level.FINE, false, "Respawned Player  " + event.getPlayer().getName() + " on " + event.getPlayer().getWorld().getName());
        }
    }
}
