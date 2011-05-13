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
package com.wormhole_xtreme.worlds_spawn.events;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;

import com.wormhole_xtreme.worlds_spawn.WormholeXTremeWorldsSpawn;
import com.wormhole_xtreme.worlds_spawn.events.player.PlayerEventHandler;

/**
 * The Class EventUtilities.
 * 
 * @author alron
 */
public class EventUtilities {
    /** The Constant thisPlugin. */
    private static final WormholeXTremeWorldsSpawn thisPlugin = WormholeXTremeWorldsSpawn.getThisPlugin();

    /** The Constant pluginManager. */
    private static final PluginManager pluginManager = thisPlugin.getServer().getPluginManager();

    /** The Constant playerEventHandler. */
    private static final PlayerEventHandler playerEventHandler = new PlayerEventHandler();

    /**
     * Register events.
     */
    public static void registerEvents() {
        pluginManager.registerEvent(Event.Type.PLAYER_RESPAWN, playerEventHandler, Priority.Lowest, thisPlugin);
    }

}
