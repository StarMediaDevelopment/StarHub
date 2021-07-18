package com.starmediadev.plugins.starhub.events;

import com.starmediadev.plugins.starhub.StarHub;
import com.starmediadev.plugins.starhub.guis.GUI;
import com.starmediadev.plugins.starhub.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

public class InventoryClickListener implements Listener {

    private StarHub main;
    private String GUI;

    public InventoryClickListener(StarHub main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        int slot = event.getSlot();
        Player player = (Player) event.getWhoClicked();

        main.getConfig().getConfigurationSection("GUIS").getKeys(false).forEach(gui -> {
            if (event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("GUIS." + gui + ".Title"))) {
                this.GUI = gui;
                runSlotAction(slot,player);
            }
        });

        event.setCancelled(true);
    }

    public void runSlotAction(int slot, Player player) {
        List<String> commands = main.getConfig().getStringList("GUIS." + GUI + ".ClickEvents");
        for (String command : commands) {
            String[] actions = command.split(";");
            int actionSlot = Integer.parseInt(actions[0]);
            if (slot == actionSlot) {
                Bukkit.dispatchCommand(player, actions[1]);
            }
        }
    }
}
