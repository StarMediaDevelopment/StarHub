package com.starmediadev.plugins.starhub;

import org.bukkit.plugin.java.JavaPlugin;

public final class StarHub extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
