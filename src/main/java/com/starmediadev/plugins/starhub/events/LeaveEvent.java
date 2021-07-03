package com.starmediadev.plugins.starhub.events;

import com.starmediadev.plugins.starhub.StarHub;
import com.starmediadev.plugins.starhub.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    private StarHub main;

    public LeaveEvent(StarHub main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Util.sendMsg(main.getConfig().getString("Leave.Messages.PlayerLeaveMessage"), player);
    }
}
