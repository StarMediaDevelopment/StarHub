package com.starmediadev.plugins.starhub.events;

import com.starmediadev.plugins.starhub.StarHub;
import com.starmediadev.plugins.starhub.functions.JoinFunctions;
import com.starmediadev.plugins.starhub.functions.MessageFunctions;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private MessageFunctions msg;
    private StarHub main;
    private JoinFunctions join;

    public JoinEvent(StarHub main) {
        this.main = main;
        this.msg = new MessageFunctions(main);
        this.join = new JoinFunctions(main);
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {
            join.giveItems(player, "FirstJoin.Items");
            playerJoin("FirstJoin", player);

            return;
        }

        if (player.hasPermission("FireCraft.isStaff")) {
            event.setJoinMessage(main.getConfig().getString("Join.Messages.StaffJoinMessage"));
            msg.sendMessages(player, "Join.Messages.StaffMOTD");
            return;
        }
        //
        event.setJoinMessage(main.getConfig().getString("Join.Messages.PlayerJoinMessage"));
        playerJoin("Join", player);
    }


    public void playerJoin(String type, Player player) {
        if (main.getConfig().getBoolean(type + ".TeleportToSpawn")) {
            Location spawn = new Location(Bukkit.getWorld(main.getConfig().getString("Spawn.WORLD")),
                    main.getConfig().getDouble("Spawn.X"), main.getConfig().getDouble("Spawn.Y"),
                    main.getConfig().getDouble("Spawn.Z"), main.getConfig().getInt("Spawn.YAW"),
                    main.getConfig().getInt("Spawn.PITCH"));
            player.teleport(spawn);
        }
        //
        player.setGameMode(GameMode.valueOf(main.getConfig().getString(type +".GameMode")));
        if (main.getConfig().getBoolean(type+ "ClearInventory")) {
            player.getInventory().clear();
        }
        //
        msg.sendMessages(player, type + ".Messages.MOTD");
    }




}
