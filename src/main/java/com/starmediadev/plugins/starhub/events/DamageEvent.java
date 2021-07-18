package com.starmediadev.plugins.starhub.events;

import com.starmediadev.plugins.starhub.StarHub;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;

public class DamageEvent implements Listener {

    private StarHub main;

    public DamageEvent(StarHub main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void voidTeleport(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
                event.setCancelled(true);
                if (isVoidWorld(player)) {
                    Bukkit.getScheduler().runTaskLater(main, new Runnable() {
                        @Override
                        public void run() {
                            Location spawn = new Location(Bukkit.getWorld(main.getConfig().getString("Spawn.WORLD")),
                                    main.getConfig().getDouble("Spawn.X"), main.getConfig().getDouble("Spawn.Y"),
                                    main.getConfig().getDouble("Spawn.Z"), main.getConfig().getInt("Spawn.YAW"),
                                    main.getConfig().getInt("Spawn.PITCH"));
                            player.teleport(spawn);
                            player.setFallDistance(0);
                            player.setHealth(20.0);
                            player.setFoodLevel(20);
                        }
                    }, 5L);
                }
            }
        }

    }


    private boolean isVoidWorld(Player player) {
        List<String> enabledWorlds = main.getConfig().getStringList("VoidTeleport.EnabledWorlds");
        String currentWorld = player.getWorld().getName();
        for(String world : enabledWorlds) {
            if(currentWorld.equals(world)) {
                return true;
            }
        }
        return false;

    }





}
