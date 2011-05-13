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
package com.wormhole_xtreme.worlds_spawn;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import com.wormhole_xtreme.worlds.WormholeXTremeWorlds;
import com.wormhole_xtreme.worlds.handler.WorldHandler;
import com.wormhole_xtreme.worlds_spawn.command.CommandUtilities;
import com.wormhole_xtreme.worlds_spawn.events.EventUtilities;

/**
 * The Class WormholeXTremeWorldsSpawn.
 * 
 * @author alron
 */
public class WormholeXTremeWorldsSpawn extends JavaPlugin {

    /** The this plugin. */
    private static WormholeXTremeWorldsSpawn thisPlugin = null;

    /** The this logger. */
    private static Logger thisLogger = null;

    /** The scheduler. */
    private static BukkitScheduler scheduler = null;

    /** The world handler. */
    private static WorldHandler worldHandler = null;

    /**
     * Gets the scheduler.
     * 
     * @return the scheduler
     */
    public static BukkitScheduler getScheduler() {
        return scheduler;
    }

    /**
     * Gets the this logger.
     * 
     * @return the this logger
     */
    public static Logger getThisLogger() {
        return thisLogger;
    }

    /**
     * Gets the this plugin.
     * 
     * @return the this plugin
     */
    public static WormholeXTremeWorldsSpawn getThisPlugin() {
        return thisPlugin;
    }

    /**
     * Gets the world handler.
     * 
     * @return the world handler
     */
    public static WorldHandler getWorldHandler() {
        return worldHandler;
    }

    /**
     * Sets the scheduler.
     * 
     * @param scheduler
     *            the new scheduler
     */
    public static void setScheduler(final BukkitScheduler scheduler) {
        WormholeXTremeWorldsSpawn.scheduler = scheduler;
    }

    /**
     * Sets the this logger.
     * 
     * @param thisLogger
     *            the new this logger
     */
    public static void setThisLogger(final Logger thisLogger) {
        WormholeXTremeWorldsSpawn.thisLogger = thisLogger;
    }

    /**
     * Sets the this plugin.
     * 
     * @param thisPlugin
     *            the new this plugin
     */
    public static void setThisPlugin(final WormholeXTremeWorldsSpawn thisPlugin) {
        WormholeXTremeWorldsSpawn.thisPlugin = thisPlugin;
    }

    /**
     * Sets the world handler.
     * 
     * @param worldHandler
     *            the new world handler
     */
    public static void setWorldHandler(final WorldHandler worldHandler) {
        WormholeXTremeWorldsSpawn.worldHandler = worldHandler;
    }

    /* (non-Javadoc)
     * @see org.bukkit.plugin.Plugin#onDisable()
     */
    @Override
    public void onDisable() {
        prettyLog(Level.INFO, true, "Disable Completed.");

    }

    /* (non-Javadoc)
     * @see org.bukkit.plugin.Plugin#onEnable()
     */
    @Override
    public void onEnable() {
        final Plugin worldsTest = getThisPlugin().getServer().getPluginManager().getPlugin("WormholeXTremeWorlds");
        try {
            if (worldsTest != null  && worldsTest.getDescription().getVersion().startsWith("0.5")) {
                setWorldHandler(WormholeXTremeWorlds.getWorldHandler());
                EventUtilities.registerEvents();
                CommandUtilities.registerCommands();
                prettyLog(Level.INFO, true, "Enable Completed.");
            }
            else {
                prettyLog(Level.SEVERE,true, "Enable FAILED. Outdated verson of Wormhole X-Treme Worlds detected. v0.5 Required.");
            }
        }
        catch (final ClassCastException e) {
            prettyLog(Level.SEVERE, true, "Enable FAILED. Missing Wormhole X-Treme Worlds Plugin.");
        }
    }

    /* (non-Javadoc)
     * @see org.bukkit.plugin.java.JavaPlugin#onLoad()
     */
    @Override
    public void onLoad() {
        setThisPlugin(this);
        setThisLogger(getThisPlugin().getServer().getLogger());
        setScheduler(getThisPlugin().getServer().getScheduler());
    }

    /**
     * 
     * prettyLog: A quick and dirty way to make log output clean, unified, and with versioning as needed.
     * 
     * @param severity
     *            Level of severity in the form of INFO, WARNING, SEVERE, etc.
     * @param version
     *            true causes version display in log entries.
     * @param message
     *            to prettyLog.
     * 
     */
    public void prettyLog(final Level severity, final boolean version, final String message) {
        final String prettyName = ("[" + getThisPlugin().getDescription().getName() + "]");
        final String prettyVersion = ("[v" + getThisPlugin().getDescription().getVersion() + "]");
        String prettyLogLine = prettyName;
        if (version) {
            prettyLogLine += prettyVersion;
            getThisLogger().log(severity, prettyLogLine + " " + message);
        }
        else {
            getThisLogger().log(severity, prettyLogLine + " " + message);
        }
    }
}
