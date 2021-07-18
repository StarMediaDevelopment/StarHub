package com.starmediadev.plugins.starhub;

import com.starmediadev.plugins.starhub.commands.Commands;
import com.starmediadev.plugins.starhub.commands.GUICommands;
import com.starmediadev.plugins.starhub.events.DamageEvent;
import com.starmediadev.plugins.starhub.events.InventoryClickListener;
import com.starmediadev.plugins.starhub.events.JoinEvent;
import com.starmediadev.plugins.starhub.events.LeaveEvent;
import com.starmediadev.plugins.starhub.guis.GuiOpeners;
import com.starmediadev.plugins.starhub.util.Util;
import org.bukkit.plugin.java.JavaPlugin;

public final class StarHub extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        Util.consoleMsg("===================== \n StarHub has enabled \n =====================");

        new DamageEvent(this);
        new JoinEvent(this);
        new LeaveEvent(this);
        new Commands(this);
        new GUICommands(this);
        new GuiOpeners(this);
        new InventoryClickListener(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
