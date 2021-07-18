package com.starmediadev.plugins.starhub.guis;

import com.starmediadev.plugins.starhub.StarHub;
import com.starmediadev.plugins.starhub.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class GuiOpeners implements Listener {

    private StarHub main;

    public GuiOpeners(StarHub main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }


    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Action a = event.getAction();
        ItemStack i = p.getItemInHand();

        if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
            List<String> itemClicks = main.getConfig().getStringList("ClickEvents.Items");
            for (String actions : itemClicks) {
                String[] action = actions.split(";");
                if (action[0].equals(ChatColor.translateAlternateColorCodes('&', i.getItemMeta().getDisplayName()))) {
                    Bukkit.dispatchCommand(p, action[1]);
                }


            }
        }
    }

}
