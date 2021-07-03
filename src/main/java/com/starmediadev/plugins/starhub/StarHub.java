package com.starmediadev.plugins.starhub;

import com.starmediadev.plugins.starhub.events.DamageEvent;
import com.starmediadev.plugins.starhub.events.JoinEvent;
import com.starmediadev.plugins.starhub.events.LeaveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class StarHub extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        new DamageEvent(this);
        new JoinEvent(this);
        new LeaveEvent(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
